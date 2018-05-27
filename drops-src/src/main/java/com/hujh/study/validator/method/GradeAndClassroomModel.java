package com.hujh.study.validator.method;

import org.hibernate.validator.constraints.Range;


public class GradeAndClassroomModel {
	
	@Range(min = 1, max = 9, message = "年级只能从1-9")
	private int grade;
	
	@Range(min = 1, max = 99, message = "班级只能从1-99")
	private int classroomNumber;

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getClassroomNumber() {
		return classroomNumber;
	}

	public void setClassroomNumber(int classroomNumber) {
		this.classroomNumber = classroomNumber;
	}
	
	
}
