/**   
* @Title: PostServiceTest.java 
* @Package come.imooc.o2o.service 
* @Description: TODO 
* @author Doris   
* @date 2020年4月11日 上午10:56:17 
* @version V1.0   
*/
package come.imooc.demo.service;

/** 
* @ClassName: PostServiceTest 
* @Description: TODO
* @author Doris 
* @date 2020年4月11日 上午10:56:17 
*  
*/

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.daily.entity.Post;
import com.daily.service.PostService;

@RunWith(SpringRunner.class)
@SpringBootTest

public class PostServiceTest {
    // 通过spring容器注入Dao的实现类
    @Autowired
    private PostService areaDao;

    @Test
    public void testGetPostList() {
        List<Post> areaList = areaDao.getPostList();
        // 验证预期值和实际值是否相符
        assertEquals(1, areaList.size());
    }

}
