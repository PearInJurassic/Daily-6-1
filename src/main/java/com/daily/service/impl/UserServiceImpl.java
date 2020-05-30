package com.daily.service.impl;

import com.daily.dao.AreaDao;
import com.daily.dao.PostDao;
import com.daily.dao.UserDao;
import com.daily.dao.UserFollowDao;
import com.daily.dto.LoginDTO;
import com.daily.dto.RegisterDTO;
import com.daily.entity.*;
import com.daily.service.UserService;
import com.daily.vo.UserInfoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private AreaDao areaDao;
    @Autowired
    private UserFollowDao userFollowDao;
    @Autowired
    private PostDao postDao;

    @Override
    public int login(LoginDTO loginDTO) {
        User user = userDao.getUserByEmail(loginDTO.getEmail());
        //邮箱不存在
        if (user == null) {
            return 2;
        }
        //邮箱与用户类型不对应
        if (!user.getUserType().equals(loginDTO.getUserType())) {
            return 2;
        }
        //用户名或密码错误
        if (!user.getUserPwd().equals(loginDTO.getPassword())) {
            return 3;
        }
        //用户被冻结
        if (user.getState().intValue() == 0) {
            return 4;
        }
        //成功登录
        return 1;
    }

    @Override
    public int insertUser(RegisterDTO registerDTO) {
        //判断邮箱是否存在
        if (userDao.existEmail(registerDTO.getEmail()) != null)
            return 2;

        User user = new User();
        BeanUtils.copyProperties(registerDTO, user);
        user.setState(1);
        user.setFansNum(0);
        user.setFollowNum(0);
        return userDao.insertUser(user);
    }

    @Override
    public int delUserById(int userId) {
        return userDao.delUserById(userId);
    }

    @Override
    public int freezeUserById(int userId) {
        return userDao.freezeUserById(userId);
    }

    @Override
    public int unfreezeUserById(int userId) {
        return userDao.unfreezeUserById(userId);
    }

    @Override
    public int getStateByUserId(int userId){
        return userDao.getStateByUserId(userId);
    }

    @Override
    public UserInfoVO getUserInfoById(int userId) {
        UserInfoVO userInfoVO = new UserInfoVO();
        User user = userDao.getUserByUserId(userId);
        BeanUtils.copyProperties(user, userInfoVO);
        Integer postNum = postDao.countPostNumByUserId(userId);
        userInfoVO.setPostNum(postNum);
        return userInfoVO;
    }
    @Override
    public Integer getUserIdByEmail(String email){
        return userDao.getUserIdByEmail(email);
    }
    @Override
    public UserExpand getUserInfoByUserId(int userId) {
        UserExpand userExpand = new UserExpand();
        User user = userDao.getUserByUserId(userId);
        userExpand.setUser(user);
        if (user.getAreaId() != null)
            userExpand.setAreaName(areaDao.getAreaNameById(user.getAreaId()));
        return userExpand;
    }

    @Transactional
    @Override
    public boolean updateUserInfo(User user) {
        if (user.getUserId() != null) {
            try {
                int effectedNum = userDao.updateUser(user);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("用户ID已得到，但更新失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("用户信息更新出现如下异常:" + e.toString());
            }
        } else {
            throw new RuntimeException("用户ID未得到");
        }
    }

    @Transactional
    @Override
    public boolean cancelFollow(int userId, int followId) {
        if (userId != 0 && followId != 0) {
            try {
                int effectedNum1 = userDao.incUserFollowNum(userId);
                int effectedNum2 = userDao.incUserFansNum(followId);
                int effectedNum3 = userFollowDao.deleteUserFollowByTwoId(userId, followId);
                if (effectedNum1 > 0 && effectedNum2 > 0 && effectedNum3 > 0) {
                    return true;
                } else {
                    throw new RuntimeException("用户ID和关注ID已得到，但取消关注失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("用户取消关注出现如下异常:" + e.toString());
            }
        } else {
            throw new RuntimeException("用户ID和关注ID未得到");
        }
    }

    @Transactional
    @Override
    public boolean addFollow(int userId, int followId) {
        if (userId != 0 && followId != 0) {
            try {
                if(userFollowDao.isFollowByTwoId(userId,followId) != 0) {
                    throw new RuntimeException("已关注，不可重复关注。");
                }
                int effectedNum1 = userDao.decUserFollowNum(userId);
                int effectedNum2 = userDao.decUserFansNum(followId);
                UserFollow userFollow = new UserFollow();
                userFollow.setFollowTime(new Date());
                userFollow.setUserId(userId);
                userFollow.setFollowId(followId);
                int effectedNum3 = userFollowDao.insertUserFollow(userFollow);
                if (effectedNum1 > 0 && effectedNum2 > 0 && effectedNum3 > 0) {
                    return true;
                } else {
                    throw new RuntimeException("用户ID和关注ID已得到，但增加关注失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("用户增加关注出现如下异常:" + e.toString());
            }
        } else {
            throw new RuntimeException("用户ID和关注ID未得到");
        }
    }

    @Transactional
    @Override
    public boolean addFollowByUserIdAndPostId(int userId, int postId) {
        if (userId != 0 && postId != 0) {
            try {
                int followId = postDao.queryUserByPostId(postId);
                if(userFollowDao.isFollowByTwoId(userId,followId) != 0) {
                    throw new RuntimeException("已关注，不可重复关注。");
                }
                int effectedNum1 = userDao.decUserFollowNum(userId);
                int effectedNum2 = userDao.decUserFansNum(followId);
                UserFollow userFollow = new UserFollow();
                userFollow.setFollowTime(new Date());
                userFollow.setUserId(userId);
                userFollow.setFollowId(followId);
                int effectedNum3 = userFollowDao.insertUserFollow(userFollow);
                if (effectedNum1 > 0 && effectedNum2 > 0 && effectedNum3 > 0) {
                    return true;
                } else {
                    throw new RuntimeException("用户ID和帖子ID已得到，但增加关注失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("用户增加关注出现如下异常:" + e.toString());
            }
        } else {
            throw new RuntimeException("用户ID和帖子ID未得到");
        }
    }

    @Override
    public List<Post> getUserFollowPostList(int userId) {
        List<Post> userFollowPostList=new ArrayList<Post>();
        List<Integer> userFollowIDList=userFollowDao.getUserFollowIDListByUserId(userId);
        List<Post> postList=postDao.queryPost();
        for(int i=0;i<postList.size();i++) {
            for(int j=0;j<userFollowIDList.size();j++) {
                if(postList.get(i).getUserId().equals(userFollowIDList.get(j))) {
                    userFollowPostList.add(postList.get(i));
                    break;
                }
            }
        }
        return userFollowPostList;
    }

    @Override
    public List<User> searchByUserName(String userName) {
        List<User> userList=userDao.searchByUserName(userName);
        for(int i=0;i<userList.size();i++) {
            userList.get(i).setEmail(null);
            userList.get(i).setUserPwd(null);
            if(userList.get(i).getState()==0) {
                userList.remove(i);
                i--;
            }
        }
        return userList;
    }
}
