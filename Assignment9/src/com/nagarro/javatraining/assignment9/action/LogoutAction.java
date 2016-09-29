package com.nagarro.javatraining.assignment9.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Action(value = "logout", results = {
			@Result(name = "success", type="redirect", location = "/index.jsp") }
	)
	
	public String execute() {
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (session.containsKey("user")) {
			session.remove("logined");
			session.remove("context");
			session.remove("user");
		}
		return SUCCESS;
	}

}
