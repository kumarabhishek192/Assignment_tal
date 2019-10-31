package com.java.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.assignment.modal.Course;
import com.java.assignment.modal.Stream;
import com.java.assignment.repository.CourseRepository;
import com.java.assignment.repository.StreamRepository;

@RestController
@RequestMapping("/api")
public class ResourceController {
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	StreamRepository streamRepository;
	
	@GetMapping("/course/all")
	public List<Course> getAllCourse(){
		return courseRepository.findAll();
	}
	
	@GetMapping("/stream/all")
	public List<Stream> getAllStream(){
		return streamRepository.findAll();
	}
	
	@PostMapping("/course/add")
	public List<Course> addCourse(@RequestBody final Course course){
		courseRepository.save(course);
		return getAllCourse();
	}
	
	@PostMapping("/stream/add")
	public List<Stream> addStream(@RequestBody final Stream stream){
		streamRepository.save(stream);
		return getAllStream();
	}
	

}
