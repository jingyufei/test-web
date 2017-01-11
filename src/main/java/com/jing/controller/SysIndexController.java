package com.jing.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baoyun.base.config.client.annotation.ZookeeperValue;
import com.jing.entity.User;
import com.jing.response.ResponseResult;
import com.jing.service.UserService;
@Controller
public class SysIndexController {
	
	private static Logger logger = LoggerFactory.getLogger(SysIndexController.class);
	
	@ZookeeperValue(key= "jdbc.url")
	private String jdbcurl;
	
	@Autowired
	private UserService userService;

    @RequestMapping("/sysindex.html")
    public String index(Model model,HttpServletRequest request, HttpServletResponse response) {
    	System.out.println(jdbcurl);
        User user = userService.getUser();
        model.addAttribute("user", user);
        System.out.println(user);
        return "sysindex";
    }
    
    @RequestMapping(value = "/saveUser",method=RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public ResponseResult saveUser(@RequestBody User user){
//    	User user = new User(name, age);
    	logger.info("save user controller, user:"+user.toString());
    	Map<String, Object> resultMap = new HashMap<String, Object>();
    	ResponseResult result = new ResponseResult();
    	try {
			result = userService.saveUser(user);
		} catch (Exception e) {
			logger.error("保存用户失败",e);
			resultMap.put("status", 500);
			resultMap.put("msg", e.getMessage());
		}
    	return result;
    }
}
