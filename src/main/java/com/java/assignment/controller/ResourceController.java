package com.java.assignment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/courses")
	public List<Course> getAllCourse(){
		return courseRepository.findAll();
	}
	
	@GetMapping("/courses/get/{id}")
	public Course getCourseById(@PathVariable("id") final int id) {
		Optional<Course> course=  courseRepository.findById(id);
		if(course.isPresent()) {
			return course.get();
		}else {
			return (new Course());
		}
	}
	
	@GetMapping("/courses/{name}")
	public Course getCourseByName(@PathVariable final String name) {
		Optional<Course> course=  courseRepository.findByName(name);
		if(course.isPresent()) {
			return course.get();
		}else {
			return (new Course());
		}
	}
	
	@PostMapping("/courses")
	public List<Course> addCourse(@RequestBody final Course course ){
		courseRepository.save(course);
		return getAllCourse();
	}
	
	@PutMapping("/courses/update/{id}")
	public List<Course> updateCourse(@PathVariable("id") final int id,@RequestBody final Course course){
		Course oldCourse = getCourseById(id);
		oldCourse.setCode(course.getCode());
		oldCourse.setName(course.getName());
		courseRepository.save(oldCourse);
		return getAllCourse();
	}
	
	@DeleteMapping("/courses/delete/{id}")
	public List<Course> deleteCourse(@PathVariable("id") final int id){
		courseRepository.delete(getCourseById(id));
		return getAllCourse();
	}
	
	@GetMapping("/streams")
	public List<Stream> getAllStream(){
		return streamRepository.findAll();
	}
	
	
	@PostMapping("/streams")
	public List<Stream> addStream(@RequestBody final Stream stream){
		streamRepository.save(stream);
		return getAllStream();
	}
}
