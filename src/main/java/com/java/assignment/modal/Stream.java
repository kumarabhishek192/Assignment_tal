package com.java.assignment.modal;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="stream", catalog="assignment")
public class Stream {
	
	@Id
	@Column(name="stream_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="code")
	private Integer code;
	
	@ManyToMany(cascade = { CascadeType.ALL })
	private Set<Course> courses = new HashSet<Course>();
	
	public Stream() {
		
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

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

//	@Override
//	public String toString() {
//		return "Stream [id=" + id + ", title=" + title + ", code=" + code + ", courses=" + courses + ", getId()="
//				+ getId() + ", getTitle()=" + getTitle() + ", getCode()=" + getCode() + ", getCourses()=" + getCourses()
//				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
//				+ "]";
//	}

}
