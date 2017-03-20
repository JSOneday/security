package com.oneday.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserAction extends BaseAction{
	
	@RequestMapping(value="login.php")
	public String login() {
		try {
			Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (obj instanceof User) {
				User user = ((User) obj);
				String username = user.getUsername();
				String password = user.getPassword();
				List<String> userRoles = new ArrayList<String>();
				Collection<GrantedAuthority> cols =  user.getAuthorities();
				for (GrantedAuthority grantedAuthority : cols) {
					userRoles.add(grantedAuthority.getAuthority());
				}
				// to do some thing ....
				/**
				 * UserInfo userInfo = new UserInfo();
				 * userInfo.setUsername(username);
				 * userInfo.setPassword(password);
				 * userInfo.setRoles(userRoles);
				 * request.getSession().setAttribute("userInfo", userInfo);
				 */
				
				System.out.println("login success.........");
				System.out.println("username:"+username);
				System.out.println("password:"+password);
				for (String str : userRoles) {
					System.out.println("user roles :"+str);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "seucess";
	}
}
