package com.hujh.study.validator.my.jsr303;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jsr303/user")
public class UserController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute(new User());
		return "user/login";
	}

	@RequestMapping(value = "/login2", method = RequestMethod.GET)
	public String login(@Validated User user, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			for (FieldError fieldError : bindingResult.getFieldErrors()) {
				System.out.println(fieldError.toString());
			}
			return "user/login";
		}
		return "user/login";
	}
}