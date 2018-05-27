package com.hujh.study.validator.my;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class Main {

	
	public static void main(String[] args) {
		// Hibernate Validation：
		Car car = new Car();
		car.setName("name");
		car.setDescp("dsecp ");
		ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
		Validator validator = vf.getValidator();
		Set<ConstraintViolation<Car>> set = validator.validate(car);
		for (ConstraintViolation<Car> constraintViolation : set) {
		    System.out.println(constraintViolation.getMessage());
		}
	}
}
