package br.univille.bluecork.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {
    
    @GetMapping("")
    public ModelAndView index(){
        Date agora = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY - HH:mm");
        String data = sdf.format(agora);

        //data = String.valueOf(agora.getTime());
        return new ModelAndView("screens/index","dataatualizada",data); 
    }
    
    @GetMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("screens/login");
	}
    
    @GetMapping("/register")
	public ModelAndView register() {
		return new ModelAndView("screens/register");
	}
}