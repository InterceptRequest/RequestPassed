import com.bjpowernode.crm.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserTest {
    @Resource
    UserService service;
    @Test
    public void Test(){
        List<String> owner = service.getOwner();
        System.out.println(owner);
    }
}
