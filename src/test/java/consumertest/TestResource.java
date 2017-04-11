package consumertest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

import junit.framework.TestCase;

public class TestResource extends TestCase{

	public void testResource(){
		ResourceBundle resource = ResourceBundle.getBundle("config");
		System.out.println(resource.getString("config.zookeeperAddress"));
		
		
		InputStream instream = TestResource.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties  = new Properties();
		try {
			properties.load(instream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(properties.getProperty("config.zookeeperAddress"));
	}
}
