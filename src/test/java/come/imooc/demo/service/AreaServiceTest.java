package come.imooc.demo.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.daily.entity.Area;
import com.daily.service.AreaService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaServiceTest {
    @Autowired
    private AreaService areaService;

    @Test
    public void testGetAreaList() {
        List<Area> areaList = areaService.getAreaList();
        assertEquals(3, areaList.size());

    }
}