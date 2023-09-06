package com.jsp.login.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.login.dao.UserDaoImp;
import com.jsp.login.model.UserModel;

@Controller
public class UserController {

	@Autowired
	UserDaoImp userdaoImp;
	
	
	@RequestMapping("deleteUser")
	public ModelAndView deleteUser(@RequestParam int id) {

		String message=userdaoImp.deleteUser(id);
		ModelAndView andView=new ModelAndView();
		andView.addObject("result",message);
		andView.setViewName("message.jsp");
		return andView;
	}
	
	@RequestMapping("displayUser")
	public ModelAndView displayUser() {
		ArrayList<UserModel> arrayList=userdaoImp.getAllUser();
		ModelAndView andView=new ModelAndView();
		andView.addObject("alluser",arrayList);
		andView.setViewName("displayuser.jsp");
		return andView;
	}
	
	
	@RequestMapping("createUser")
	public ModelAndView createUser() {
		ModelAndView andView=new ModelAndView();
		andView.addObject("user",new UserModel());
		andView.setViewName("createuser.jsp");
		return andView;
	}
	
	@RequestMapping("saveUser")
	public ModelAndView saveUser(@ModelAttribute UserModel user) {
		
		String message=userdaoImp.saveUser(user);
		ModelAndView andView=new ModelAndView();
		andView.addObject("result",message);
		andView.setViewName("message.jsp");
		return andView;
	}
	
}
