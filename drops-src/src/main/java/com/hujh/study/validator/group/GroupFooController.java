package com.hujh.study.validator.group;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupFooController {
	@RequestMapping("/drink")
	public String drink(@Validated({GroupFoo.Adult.class}) GroupFoo groupFoo, BindingResult bindingResult) {
	    if(bindingResult.hasErrors()){
	        for (FieldError fieldError : bindingResult.getFieldErrors()) {
	        		System.out.println(fieldError.toString());
	        	
	        }
	        return "fail";
	    }
	    return "success";
	}
	
	
	
	@RequestMapping("/live")
	public String live(@Validated GroupFoo groupFoo, BindingResult bindingResult) {
	    if(bindingResult.hasErrors()){
	        for (FieldError fieldError : bindingResult.getFieldErrors()) {
	        		System.out.println(fieldError.toString());
	        	
	        }
	        return "fail";
	    }
	    return "success";
	}
}

