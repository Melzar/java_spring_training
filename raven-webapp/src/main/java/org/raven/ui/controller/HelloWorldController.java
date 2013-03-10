package org.raven.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController
{
	@RequestMapping("/HelloWorld")
	public String printHelloWorld(Model model)
	{
		model.addAttribute("message", "Hello world");
		return "HelloWorld";
	}
}
