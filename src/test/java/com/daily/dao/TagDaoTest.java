/**   
* @Title: TagDaoTest.java 
* @Package com.daily.dao 
* @Description: TODO 
* @author Doris   
* @date 2020年4月30日 下午4:36:57 
* @version V1.0   
*/
package com.daily.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.daily.entity.Tag;

/**
 * @ClassName: TagDaoTest
 * @Description: TODO
 * @author Doris
 * @date 2020年4月30日 下午4:36:57
 * 
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TagDaoTest {
    @Autowired
    private TagDao tagDao;

    @Test
    public void testQueryTagByPostId() {
        List<Tag> areaList = tagDao.queryTagByPostId(1);

        assertEquals(1, areaList.size());
    }

    @Test
    public void testInsertTag() {
        Tag tag = new Tag();
        tag.setTagContent("生活");
        tag.setPostId(2);
        int i = tagDao.insertTag(tag);

        assertEquals(1, i);
    }

    @Test
    public void testDeleteTag() {
        int i = tagDao.deleteTag(2);
        // 验证预期值和实际值是否相符
        assertEquals(1, i);
    }

}
