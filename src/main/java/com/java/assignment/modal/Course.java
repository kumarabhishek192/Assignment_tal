package com.java.assignment.modal;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {

	@Id
	@Column(name="course_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="code")
	private Integer code;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "course_stream", joinColumns = { @JoinColumn(name = "course_id") }, inverseJoinColumns = {
			@JoinColumn(name = "stream_id") })
	private Set<Stream> streams = new HashSet<Stream>();
	
	public Course(){
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Stream> getStreams() {
		return streams;
	}

	public void setStreams(Set<Stream> streams) {
		this.streams = streams;
	}

	
	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	
//	@Override
//	public String toString() {
//		return "Course [id=" + id + ", title=" + title + ", streams=" + streams + ", getId()=" + getId()
//				+ ", getTitle()=" + getTitle() + ", getStreams()=" + getStreams() + ", getClass()=" + getClass()
//				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
//	}
}
