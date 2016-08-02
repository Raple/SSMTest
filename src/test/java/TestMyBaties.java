//import java.util.logging.Logger;

import javax.annotation.Resource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.cn.lyp.pojo.User;
import com.cn.lyp.service.IUserService;
import com.cn.lyp.serviceImpl.UserServiceImpl;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})

public class TestMyBaties {
 //private static Logger logger=Logger.getLogger(TestMyBaties.class);
	@Resource
private IUserService userService=null;
 
 @Before
 public void before()
 {	
	 System.out.println("-------start-----");
	// userService=new UserServiceImpl();
 }
 
 @Test
 public void test()
 {
	User user=userService.getUserById(1);
	System.out.println(user.getUser_name());
 }
 
 @After
 public void after()
 {
	 System.out.println("-------end----------");
 }
}
