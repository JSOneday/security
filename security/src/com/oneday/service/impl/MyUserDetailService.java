package com.oneday.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.oneday.entity.User;
import com.oneday.service.UserService;
public class MyUserDetailService implements UserDetailsService {
	
	@Autowired@Qualifier("userService")
	private UserService userService;
	
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		User user=userService.getQueryByname(username);
		if(user==null){
			throw new UsernameNotFoundException("用户不存在，请重新输入！");
		}else{
			Collection<GrantedAuthority> auths=new ArrayList<GrantedAuthority>();
			GrantedAuthorityImpl auth=new GrantedAuthorityImpl("ROLE_ADMIN");
			auths.add(auth);
			boolean enabled = true;
			boolean accountNonExpired = true;
			boolean credentialsNonExpired = true;
			boolean accountNonLocked = true;
			User userInfo=new User(user.getUname(), enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, auths);
			return userInfo;
		}
	}
}
