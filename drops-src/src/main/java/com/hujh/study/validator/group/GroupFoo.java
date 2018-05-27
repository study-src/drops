package com.hujh.study.validator.group;

import javax.validation.constraints.Min;

public class GroupFoo {

	@Min(value = 18,groups = {Adult.class})
    private Integer age;
	
	public interface Adult{}

    public interface Minor{}
    
}
