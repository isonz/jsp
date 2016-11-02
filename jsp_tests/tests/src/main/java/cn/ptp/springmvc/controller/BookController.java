package cn.ptp.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController 
{  
	@RequestMapping("/book")
	public String doaaa(Model model){
		model.addAttribute("result", "hello");
		return "index";
	}
      
}  
