package org.raven.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApplicationController
{
	@RequestMapping("/")
	public String prepareMainPage(Model model)
	{
		model.addAttribute("message", "Hello world");
		return "MainPage";
	}

	@RequestMapping("/login")
	public String prepareLoginPage(Model model)
	{
		return "Login";
	}

	@RequestMapping("/login/register")
	public String prepareRegister(Model model)
	{
		return "Register";
	}

}
