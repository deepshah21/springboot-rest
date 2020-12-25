package com.demo.user;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity(name = "user")
public class User {

	@Id
	@GeneratedValue
	private Integer id;
	@Size(min=2, message="Name should have atleast 2 characters")
	private String name;
	private Date bod;
	
	
	public User() {
		super();
	}
	public User(Integer id, String name, Date bod) {
		super();
		this.id = id;
		this.name = name;
		this.bod = bod;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBod() {
		return bod;
	}
	public void setBod(Date bod) {
		this.bod = bod;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", bod=" + bod + "]";
	}
	
}
