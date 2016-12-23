package consumertest;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jing.entity.User;
import com.jing.service.UserService;

public class ConsumerMain {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "dubbo-consumer.xml" });
		context.start();
		UserService userService = (UserService) context.getBean("userService");
		
		User user = userService.getUser();
		System.out.println(user.toString());
	}
}
