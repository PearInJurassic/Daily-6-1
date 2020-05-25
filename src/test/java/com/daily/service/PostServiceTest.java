/**   
* @Title: PostServiceTest.java 
* @Package come.imooc.o2o.service 
* @Description: TODO 
* @author Doris   
* @date 2020年4月11日 上午10:56:17 
* @version V1.0   
*/
package com.daily.service;

/** 
* @ClassName: PostServiceTest 
* @Description: TODO
* @author Doris 
* @date 2020年4月11日 上午10:56:17 
*  
*/

import com.daily.entity.Post;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest

public class PostServiceTest {
    // 通过spring容器注入Dao的实现类
    @Autowired
    private PostService postService;

    @Test
    @Ignore
    public void testGetPostList() {
        List<Post> areaList = postService.getPostList();
        // 验证预期值和实际值是否相符
        assertEquals(1, areaList.size());
    }

}
