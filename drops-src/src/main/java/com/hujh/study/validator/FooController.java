package com.hujh.study.validator;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FooController {

	/**
	 * <1> 参数Foo前需要加上@Validated注解，表明需要spring对其进行校验，
	 * 		而校验的信息会存放到其后的BindingResult中。
	 * 		注意，必须相邻，如果有多个参数需要校验，形式可以如下。
	 * 		foo(@Validated Foo foo, BindingResult fooBindingResult ，
	 * 		@Validated Bar bar, BindingResult barBindingResult);
	 * 		即一个校验类对应一个校验结果。
	   <2> 校验结果会被自动填充，在controller中可以根据业务逻辑来决定具体的操作，如跳转到错误页面。
	 */
	
    @RequestMapping("/foo")
    public String foo(@Validated Foo foo, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                System.out.println(fieldError.toString());
            }
            return "fail";
        }
        return "success";
    }

    @RequestMapping("/foo1")
    public String foo1(@Valid Foo foo, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
            	 	System.out.println(fieldError.toString());
            }
            return "fail";
        }
        return "success";
    }
    
}