package com.jing;

import java.util.ResourceBundle;

import javax.servlet.ServletContextEvent;

import org.springframework.web.context.ContextLoaderListener;

import com.baoyun.base.config.client.zookeeper.ZookeeperProperties;
import com.baoyun.base.config.client.zookeeper.ZookeeperSpringApplication;



public class ZookeeperConfigListener extends ContextLoaderListener{

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("-------------开始初始化自定义项目的上下文--------------");
		
		ResourceBundle resource = ResourceBundle.getBundle("config");
		@SuppressWarnings("rawtypes")
		ZookeeperProperties zp = new ZookeeperProperties();
		zp.setZookeeperAddress(resource.getString("config.zookeeperAddress"));
		zp.setPropertiesPath(resource.getString("config.propertiesPath"));
		zp.afterPropertiesSet();
		
		ZookeeperSpringApplication.setZookeeperProperties(zp);
		super.contextInitialized(event);
	}
}
