package cn.ptp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController 
{

	@RequestMapping("/user")
	public String index(Model model)
	{
		model.addAttribute("str", "User");
		return "user/index";
	}
	
	@RequestMapping("/user/info")
	public String info(Model model)
	{
		model.addAttribute("str", "User INFO");
		return "user/info";
	}
	
}
