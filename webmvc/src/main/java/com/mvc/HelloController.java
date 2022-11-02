package com.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@GetMapping("/")
	public String sayHello() {
		return  "index";
	}
	
	@GetMapping("/bye")
	@ResponseBody
	public String sayBye() {
		return  "bye bye";
	}
}
