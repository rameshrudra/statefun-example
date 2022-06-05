package com.product.contacts;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contacts/")
public class ContactsController {

	@RequestMapping("/")
	public String home() {
		return "Hello Docker World";
	}

	@GetMapping("test")
	public ResponseEntity<String> fetchSearchResults() {
		return new ResponseEntity<String>("Hello World!", HttpStatus.OK);
	}
}
