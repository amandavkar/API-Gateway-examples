package com.atul.main;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Client2Controller {

	@RequestMapping("/client2")
	public String getMessage() {
		return "Message from Client2";
		
	}
}
