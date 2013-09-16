package com.duan.beans;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import java.io.Serializable;

@XStreamAlias("member")
public class Person implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7139978490881468546L;
	
	@XStreamAsAttribute
	private String role;
	
	private String name;
	
	private String gender;
	
	private String age;
	
	public String getRole()
	{
		return role;
	}
	
	public void setRole(String role)
	{
		this.role = role;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getGender()
	{
		return gender;
	}
	
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	
	public String getAge()
	{
		return age;
	}
	
	public void setAge(String age)
	{
		this.age = age;
	}
	
	@Override
	public String toString()
	{
		return "Person [age=" + age + ", gender=" + gender + ", name=" + name
				+ ", role=" + role + "]";
	}
	
}