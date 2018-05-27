package com.hujh.study.validator.boot;

import org.hibernate.validator.constraints.ScriptAssert;

@ScriptAssert(lang = "javascript", script = "com.hujh.study.validator.boot.Student.checkParams(_this.name,_this.age,_this.classes)", message = "")
public class Student {
	
	private String name;
	private int age;
	private String classess;

	// 注意进行校验的方法要写成静态方法，否则会出现
	// TypeError: xxx is not a function 的错误
	public static boolean checkParams(String name, int age, String classes) {
		if (name != null && age > 8 & classes != null) {
			return true;
		} else {
			return false;
		}
	}
}