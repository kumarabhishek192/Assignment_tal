package com.java.assignment.modal;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

/**
 * Stream Entity
 * 
 * @author AbhishekK
 *
 */
@Entity
@Table(name = "stream", catalog = "assignment")
public class Stream extends ModalDao{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Stream Id",name="id",required=true,value="202")
	private Integer id;

	@Column(name = "name")
	@ApiModelProperty(notes = "Name of the Stream",name="name",required=true,value="Computer Eng.")
	private String name;

	@Column(name = "code")
	@ApiModelProperty(notes = "Stream Codet",name="code",required=true,value="10001")
	private Integer code;

	@OneToMany(cascade=CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "stream_id")
	private Set<Course> courses = new HashSet<>();

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

	@Override
	public String toString() {
		return "Stream [id=" + id + ", name=" + name + ", code=" + code + ", courses=" + courses + "]";
	}

}
