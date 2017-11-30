package com.pms.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="user")
public class User {
	
	@Id
	@NotEmpty(message="登录账号不能为空!!!!!!!!!!!!！")
	private String id;
	@Pattern(regexp="[0-9a-zA-Z]{6,30}", message="密码是6-30个字符，必须是字母或数字组合！")
	private String password;
	private String name;
	@NotEmpty(message="邮箱不能为空！")
	@Email(message="邮件格式不正确！")
	private String email;
	private String tel;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
}
