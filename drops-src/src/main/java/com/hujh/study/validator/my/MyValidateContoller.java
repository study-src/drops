package com.hujh.study.validator.my;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hujh.study.validator.group.GroupFoo;

@RestController
@RequestMapping("/my")
public class MyValidateContoller {

	@Autowired
	Validator globalValidator;
	
	@RequestMapping("/validate")
	public String validate() {
		Car car = new Car();
		car.setName("name");
		car.setDescp("dsecp ");

		ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
		Validator validator = vf.getValidator();
		Set<ConstraintViolation<Car>> set = validator.validate(car);
		for (ConstraintViolation<Car> constraintViolation : set) {
		    System.out.println(constraintViolation.getMessage());
		}
	    return "success";
	}
	
	@RequestMapping("/car")
	public String drink(@Validated Car car, BindingResult bindingResult) {
	    if(bindingResult.hasErrors()){
	        for (FieldError fieldError : bindingResult.getFieldErrors()) {
	        		System.out.println(fieldError.toString());
	        	
	        }
	        return "fail";
	    }
	    return "success";
	}
}
