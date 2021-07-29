import com.bjpowernode.crm.pojo.Type;
import com.bjpowernode.crm.pojo.Value;
import com.bjpowernode.crm.service.TypeService;
import com.bjpowernode.crm.service.ValueService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class Tests {
    @Resource
    TypeService typeService;

    @Resource
    ValueService valueService;
    @Test
    public void test05(){
        List<Value> all = valueService.getAll();
        System.out.println(all);
    }
    @Test
    public void test02(){
        List<Type> all = typeService.getAll();
        System.out.println(all);
    }
    @Test
    public void test01(){
        Type type = new Type();
        type.setCode("12323");
        type.setCode("1234");
        type.setCode("1232");
        String [] strings = {"123321","1qwe"};
        typeService.delete(strings);
        test02();
    }
    @Test
    public void test04(){
        Type type = new Type();
        type.setCode("2");
        type.setDescription("1234");
        type.setName("1232");

        typeService.update(type);
        test02();
    }

}
