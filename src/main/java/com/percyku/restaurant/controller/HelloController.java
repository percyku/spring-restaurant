package com.percyku.restaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
	 @RequestMapping(value = "/hello_world", method = RequestMethod.GET)
	    public String printHelloWorld(ModelMap modelMap){

	        modelMap.addAttribute("message","Hello World and Welcome to Spring MVC!");

	        return "hello_world";
	    }
}
