package com.oneday.filter;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.web.FilterChainProxy;

public class MyFilterChainProxy extends FilterChainProxy{
	Map<String, String> filterUrlMap = new HashMap<String, String>();
	public void setFilterUrlMap(Map<String, String> filterUrlMap) {
		this.filterUrlMap = filterUrlMap;
	}
}
