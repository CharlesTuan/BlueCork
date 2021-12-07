package br.univille.bluecork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {

	@GetMapping("")
	public ModelAndView index() {
		return new ModelAndView("screens/index");
	}

	@GetMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("screens/login");
	}

	@GetMapping("/register")
	public ModelAndView register() {
		return new ModelAndView("screens/register");
	}

	@GetMapping("/home")
	public ModelAndView home() {
		return new ModelAndView("screens/home");
	}
	
	@GetMapping("/search")
	public ModelAndView search() {
		return new ModelAndView("screens/search");
	}
	
	@GetMapping("/chat")
	public ModelAndView chat() {
		return new ModelAndView("screens/chat");
	}
	
	@GetMapping("/user")
	public ModelAndView user() {
		return new ModelAndView("screens/user");
	}
}