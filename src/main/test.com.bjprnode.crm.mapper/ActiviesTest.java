import com.bjpowernode.crm.mapper.ActivitiesMapper;
import com.bjpowernode.crm.pojo.Activities;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ActiviesTest {
    @Resource
    ActivitiesMapper activitiesMapper;

    @Test
    public void Test (){
        List<Activities> owner = activitiesMapper.get(new HashMap() {{
            put("owner", "90");
            put("name", "80");
            put("startDate", "90");
            put("endDate", "90");
        }});
        System.out.println(owner);
    }
}
