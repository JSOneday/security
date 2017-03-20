package com.oneday.web;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
public class BaseAction {	
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected final Log log = LogFactory.getLog(getClass());
	
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
}
