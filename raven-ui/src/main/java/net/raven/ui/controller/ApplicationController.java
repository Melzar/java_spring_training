package net.raven.ui.controller;

import net.raven.core.dao.user.UserManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApplicationController
{

	private final UserManager userManager;

	@Autowired
	public ApplicationController(UserManager userManager)
	{
		this.userManager = userManager;
	}

	@RequestMapping("/")
	public String prepareMainPage(Model model)
	{
		return "MainPage";
	}

	@RequestMapping("/login")
	public String prepareLoginPage(Model model)
	{
		model.addAttribute("userList", userManager.getUserList());
		return "Login";
	}

	@RequestMapping("/login/register")
	public String prepareRegister(Model model)
	{
		return "Register";
	}

}
