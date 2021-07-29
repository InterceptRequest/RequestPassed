import com.bjpowernode.crm.mapper.CommonsMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class CommonsTest {
    @Resource
    CommonsMapper commonsMapper;
    @Test
    public void Test1(){
        List<Map> tbl_marketing_activities = commonsMapper.getAll("tbl_marketing_activities");
        System.out.println(tbl_marketing_activities);
    }
    @Test
    public void Test2(){
        Map tbl_marketing_activities = commonsMapper.getId("tbl_marketing_activities", "34");
        System.out.println(tbl_marketing_activities);
    }
    @Test
    public void Test3(){
        commonsMapper.insert("tbl_marketing_activities",new HashMap(){{
            put("id","4");
            put("owner","2000");
            put("name","213");
            put("startDate","fds发士大夫");
            put("endDate","士大夫");
            put("cost","1233");
            put("description","23");
        }});
        Test1();
    }
    @Test
    public void Test4(){
        commonsMapper.delete("tbl_marketing_activities","1","2");

        Test1();
    }
    @Test
    public void Test5(){
        commonsMapper.update("tbl_marketing_activities",new HashMap(){{
            put("id","34");
            put("owner","00000");
            put("name","佛挡杀佛21312312312312");
            put("startDate","4");
            put("endDate","4");
            put("cost","4");
            put("description","4");
        }});
        Test1();
    }

}
