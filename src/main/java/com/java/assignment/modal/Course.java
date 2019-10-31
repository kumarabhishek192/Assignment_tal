package com.java.assignment.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "course")
public class Course extends ModalDao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Name of the Student",name="name",required=true,value="test name")
	private Integer id;

	@Column(name = "name")
	@ApiModelProperty(notes = "Name of the Student",name="name",required=true,value="test name")
	private String name;

	@Column(name = "code")
	@ApiModelProperty(notes = "Name of the Student",name="name",required=true,value="test name")
	private Integer code;

	@ManyToOne
	private Stream stream;

	public Stream getStream() {
		return stream;
	}

	public void setStream(Stream stream) {
		this.stream = stream;
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

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", code=" + code + "]";
	}

}
