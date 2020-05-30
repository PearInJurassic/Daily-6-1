package com.daily.service.impl;

import com.daily.dao.PostDao;
import com.daily.dao.TipoffDao;
import com.daily.entity.Tipoff;
import com.daily.service.TipoffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoffServiceImpl implements TipoffService {
    @Autowired
    private TipoffDao tipoffDao;
    @Autowired
    private PostDao postDao;

    @Override
    public boolean addTipoff(Tipoff tipoff) {
        // 空值判断，主要是判断areaName不为空
        if (tipoff.getPostId() != null && !"".equals(tipoff.getUserId())) {
            // 设置默认值

            try {
                Tipoff t = tipoffDao.queryTipoff(tipoff.getUserId(), tipoff.getPostId());
                if (t == null) {
                    int res = tipoffDao.insertTipoff(tipoff);
                    if (res > 0) {
                        int res2=postDao.incTipoffNum(tipoff.getPostId());
                        if(res2>0){
                            return true;
                        }else{
                            throw new RuntimeException("帖子不存在！");
                        }

                    } else {
                        throw new RuntimeException("举报失败!");

                    }
                } else {
                    throw new RuntimeException("该用户已举报该帖子，不可重复举报!");
                }
            } catch (Exception e) {
                throw new RuntimeException("举报失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("用户id或帖子id不能为空！");
        }
    }
}
