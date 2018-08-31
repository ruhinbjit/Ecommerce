package com.ecommerce.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.User;
import com.ecommerce.response.JsonUserResponse;
import com.ecommerce.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping(value = "/saveUser", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public JsonUserResponse saveApplications(@ModelAttribute @Valid User user, BindingResult result) {
		JsonUserResponse response = new JsonUserResponse();
		Date date=new Date();
		user.setCreatedDate(date);
		if (result.hasErrors()) {
			// Get error message
			System.out.println("err");
			Map<String, String> errors = result.getFieldErrors().stream()
					.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
			response.setValidated(false);
			response.setErrorMessages(errors);
		} else {
			System.out.println(user+" hellooooooo");
			response.setValidated(true);
			response.setUser(user);
			userService.addUser(user);

		}
		return response;
	}

	@GetMapping(value = "/list")
	@ResponseBody
	public List<User> getUserList() {
		return userService.getUserList();
	}
}
