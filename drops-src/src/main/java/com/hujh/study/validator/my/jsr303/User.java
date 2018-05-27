package com.hujh.study.validator.my.jsr303;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class User {
	
    @NotEmpty(message = "用户名不能为空")
    private String username;
    @Size(min=6 ,max= 20 ,message = "密码长度不符合标准")
    private String password;
    
    private String nickname;
    
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
    
}