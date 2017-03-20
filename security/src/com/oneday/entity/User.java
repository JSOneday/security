package com.oneday.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class User extends BaseObject implements UserDetails{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String uname;
	private String password;
	private boolean enabled = false;
	private boolean accountNonExpired = false;
	private boolean credentialsNonExpired = false;
	private boolean accountNonLocked = false;
	private Collection<GrantedAuthority> auths;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}
	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}
	
	public Collection<GrantedAuthority> getAuths() {
		return auths;
	}
	public void setAuths(Collection<GrantedAuthority> auths) {
		this.auths = auths;
	}
	public User(){}
	public User(String uname, String password) {
		super();
		this.uname = uname;
		this.password = password;
	}
	public User(String uname, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked, Collection<GrantedAuthority> auths) {
		super();
		this.uname = uname;
		this.enabled = enabled;
		this.accountNonExpired = accountNonExpired;
		this.credentialsNonExpired = credentialsNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.auths = auths;
	}
	
	public Collection<GrantedAuthority> getAuthorities() {
		return null;
	}
	public String getUsername() {
		return this.uname;
	}
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}
	public boolean isEnabled() {
		return enabled;
	}
}
