package com.hujh.study.validator.my.validator;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class HelloController {

	// 我们知道在Controller类中通过@InitBinder标记的方法只有在请求当前Controller的时候才会被执行
	// 所以在这里注册校验器
	// 基于Validator接口的验证.  只对当前类有效
	/**
	 * 全部有效需要配置：
	 * <mvc:annotation-driven validator="userValidator"/>
    		<bean id="userValidator" class="com.xxx.xxx.UserValidator"/>
	 */
	@InitBinder
	public void initBainder(DataBinder binder) {
		binder.replaceValidators(new UserValidator());
	}

	// 这个方法主要是跳转到登录页面
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute(new User());
		return "user/login";
	}

	// 处理登录表单
	@RequestMapping(value = "/login2", method = RequestMethod.GET)
	public String login(@Validated User user, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			for (FieldError fieldError : bindingResult.getFieldErrors()) {
				System.out.println(fieldError.toString());

			}
			return "user/login";
		}
		return "--";
	}
}