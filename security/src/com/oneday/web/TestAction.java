package com.oneday.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oneday.entity.User;
import com.oneday.service.BaseService;
import com.oneday.service.UserService;

@Controller
public class TestAction extends BaseAction {
	
	@Autowired
	private BaseService baseService;
	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}
	@Autowired@Qualifier("userService")
	private UserService userService;
	
	public String admin(){
		System.out.println("test...admin..");
		return "sucess";
	}
	
	public String user(){
		System.out.println("test...user..");
		return "sucess";
	}
	
	@RequestMapping(value="/index.php")
	public String indexPages(ModelMap model){
		User user=baseService.getObject(User.class, 1L);
		model.put("user",user);
		User user1=userService.getQueryByname("jack");
		System.err.println(user1.getPassword());
		return "user";
	}
}
