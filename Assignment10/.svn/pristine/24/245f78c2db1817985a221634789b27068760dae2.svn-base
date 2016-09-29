package com.nagarro.javatraining.assignment10.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.javatraining.assignment10.Dao.UserDao;
import com.nagarro.javatraining.assignment10.Util.AppContextUtil;
import com.nagarro.javatraining.assignment10.model.User;

@Controller
public class Register {
	
	@RequestMapping(value ="/register" , method=RequestMethod.GET)
	public ModelAndView getRegister(HttpSession session){
				
		ModelAndView modelAndView = new ModelAndView("register") ;
		return modelAndView ;
	}
	
	@RequestMapping(value ="/register" , method=RequestMethod.POST)
	public ModelAndView registerUser(@Valid @ModelAttribute("registerDetails")User user, BindingResult result){
		
		ModelAndView modelAndView = new ModelAndView("register") ;
		UserDao obj = (UserDao)AppContextUtil.context.getBean("userdao");
		try {
			obj.saveUser(user);
		} catch (Exception e) {
			if(!result.hasErrors())
			{
				ObjectError error = new ObjectError("uniqueUserError", "User name should be Unique");
				result.addError(error);
				modelAndView.addObject("InvalidationMsg", "User name should be Unique");
			}
		}
		if(result.hasErrors())
		{
			return modelAndView ;
		}
		
		modelAndView = new ModelAndView("redirect:login") ;
		return modelAndView ;
	}
}
