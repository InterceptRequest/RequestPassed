import com.bjpowernode.crm.pojo.Dept;
import com.bjpowernode.crm.service.DeptService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class DeptTest {
    @Resource
    DeptService deptService;

    @Test
    public void test1(){
        List<Dept> aLl = deptService.getALl();
        System.out.println(aLl);
    }
    @Test
    public void test2(){
        Dept aLl = deptService.getId("3eb28106d3bf44daa0e9d32b26c82e84");
        System.out.println(aLl);
    }
    @Test
    public void test3(){
        Dept dept = new Dept();
        dept.setDescription("1");
        dept.setId("1");
        dept.setNo("1");
        dept.setName("1");
        dept.setManager("1");
        dept.setPhone("1");
        deptService.insert(dept);
        test1();
    }
    @Test
    public void test4(){
        Dept dept = new Dept();
        dept.setDescription("2");
        dept.setId("1");
        dept.setNo("1");
        dept.setName("1");
        dept.setManager("1");
        dept.setPhone("1");
        deptService.update(dept);
        test1();
    }
    @Test
    public void test5(){

        deptService.delete(1);
        test1();
    }
}
