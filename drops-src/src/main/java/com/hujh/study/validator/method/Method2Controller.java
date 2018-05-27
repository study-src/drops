package com.hujh.study.validator.method;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Range;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class Method2Controller {

	// 这种情况不需要方法验证
	@RequestMapping(value = "/paramErrorTest", method = RequestMethod.GET)
	public String paramErrorTest(@Valid @ModelAttribute GradeAndClassroomModel gradeAndClassroomModel,
			BindingResult result) {
		System.out.println("paramErrorTest....");
		if (result.hasErrors()) {
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError error : errors) {
				System.out.println(error);
			}
			return "fail";
		}
		return "success";
	}

	// 这种情况需要增加 类上面的 方法级别验证
	@RequestMapping(value = "/teacherName", method = RequestMethod.GET)
	public String teacherName(
			@Range(min = 1, max = 9, message = "年级只能从1-9") @RequestParam(name = "grade", required = true) int grade,
			@Min(value = 1, message = "班级最小只能1") @Max(value = 99, message = "班级最大只能99") @RequestParam(name = "classroom", required = true) int classroom) {
		
		return "success";
	}

}
