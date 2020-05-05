/**   
* @Title: LikeDaoTest.java 
* @Package com.daily.dao 
* @Description: TODO 
* @author Doris   
* @date 2020年4月28日 下午3:18:03 
* @version V1.0   
*/
package com.daily.dao;

import com.daily.entity.Like;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * @ClassName: LikeDaoTest
 * @Description: TODO
 * @author Doris
 * @date 2020年4月28日 下午3:18:03
 * 
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // 按方法名大小升序执行
public class LikeDaoTest {
    @Autowired
    LikeDao likeDao;

    @Test
    public void testQueryLikeNumByPostId() {
        int num = likeDao.queryLikeNumByPostId(3);
        assertEquals(2, num);
    }

    @Test
    public void testQueryLikeByPostIdAndUserId() {

        int num = likeDao.queryLikeByPostIdAndUserId(4, 8);
        assertEquals(0, num);
    }

    @Test
    public void testInsertLike() {
        Like like = new Like();
        like.setPostId(4);
        like.setUserId(1);
        int num = likeDao.insertLike(like);
        assertEquals(1, num);
    }

    @Test
    public void testDeleteLike() {
        int num = likeDao.deleteLike(3, 5);
        assertEquals(1, num);
    }

}
