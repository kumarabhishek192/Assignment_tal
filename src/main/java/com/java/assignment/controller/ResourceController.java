package com.java.assignment.controller;

import java.util.List;
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
import com.java.assignment.service.ResourceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
@Api(value = "Admin Controller", description = "REST APIs for Admin Controller")
public class ResourceController {

	@Autowired
	ResourceService resourceService;
	
	@ApiOperation(value = "Get list of Students in the System ", response = Iterable.class, tags = "getStudents")
	@ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "not authorized!"),
	            @ApiResponse(code = 403, message = "forbidden!!!"),
	            @ApiResponse(code = 404, message = "not found!!!") })
	@GetMapping("/streams")
	public List<Stream> getAllStream() {
		return resourceService.getAllStream();
	}

	@ApiOperation(value = "Get list of Students in the System ", response = Iterable.class, tags = "getStudents")
	@ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "not authorized!"),
	            @ApiResponse(code = 403, message = "forbidden!!!"),
	            @ApiResponse(code = 404, message = "not found!!!") })
	@GetMapping("/stream/{id}")
	public Stream getStreamById(@PathVariable("id") final int id) {
		return resourceService.getStreamById(id);
	}

	@ApiOperation(value = "Get list of Students in the System ", response = Iterable.class, tags = "getStudents")
	@ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "not authorized!"),
	            @ApiResponse(code = 403, message = "forbidden!!!"),
	            @ApiResponse(code = 404, message = "not found!!!") })
	@PostMapping("/streams")
	public List<Stream> addStream(@RequestBody final List<Stream> stream) {
		return resourceService.addStream(stream);
	}

	/**
	 * 
	 * @param id
	 * @param stream
	 * @return
	 */
	@ApiOperation(value = "Get list of Students in the System ", response = Iterable.class, tags = "getStudents")
	@ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "not authorized!"),
	            @ApiResponse(code = 403, message = "forbidden!!!"),
	            @ApiResponse(code = 404, message = "not found!!!") })
	@PutMapping("/streams/{id}")
	public Stream updateStream(@PathVariable("id") final int id, @RequestBody final Stream stream) {
		return resourceService.updateStream(id, stream);
	}

	/**
	 * Delete Stream from the database
	 * @param id for deleting by id
	 * @return list of rest stream
	 */
	@ApiOperation(value = "Get list of Students in the System ", response = Iterable.class, tags = "getStudents")
	@ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "not authorized!"),
	            @ApiResponse(code = 403, message = "forbidden!!!"),
	            @ApiResponse(code = 404, message = "not found!!!") })
	@DeleteMapping("/streams/{id}")
	public void deleteStream(@PathVariable("id") final int id) {
		resourceService.deleteStream(id);
	}
	
	
	@ApiOperation(value = "Get list of Students in the System ", response = Iterable.class, tags = "getStudents")
	@ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "not authorized!"),
	            @ApiResponse(code = 403, message = "forbidden!!!"),
	            @ApiResponse(code = 404, message = "not found!!!") })
	@PostMapping("/streams/{id}/courses")
	public void addStreamCourses(@RequestBody final List<Course> course,@PathVariable("id") final int id) {
		resourceService.addStreamCourses(course, id);
	}
	
	
	@ApiOperation(value = "Get list of Students in the System ", response = Iterable.class, tags = "getStudents")
	@ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "not authorized!"),
	            @ApiResponse(code = 403, message = "forbidden!!!"),
	            @ApiResponse(code = 404, message = "not found!!!") })
	@GetMapping("/courses")
	public List<Course> getAllCourses() {
		return resourceService.getAllCourses();

	}

	@ApiOperation(value = "Get list of Students in the System ", response = Iterable.class, tags = "getStudents")
	@ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "not authorized!"),
	            @ApiResponse(code = 403, message = "forbidden!!!"),
	            @ApiResponse(code = 404, message = "not found!!!") })
	@GetMapping("/courses/name/{name}")
	public Course getCourseByName(final String name) {
		return resourceService.getCourseByName(name);
	}

	@ApiOperation(value = "Get list of Students in the System ", response = Iterable.class, tags = "getStudents")
	@ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "not authorized!"),
	            @ApiResponse(code = 403, message = "forbidden!!!"),
	            @ApiResponse(code = 404, message = "not found!!!") })
	@GetMapping("/courses/{id}")
	public Course getCourseById(@PathVariable("id") final int id) {
		return resourceService.getCourseById(id);
	}

	@ApiOperation(value = "Get list of Students in the System ", response = Iterable.class, tags = "getStudents")
	@ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "not authorized!"),
	            @ApiResponse(code = 403, message = "forbidden!!!"),
	            @ApiResponse(code = 404, message = "not found!!!") })
	@PostMapping("/courses")
	public List<Course> addCourses(@RequestBody final List<Course> courseList) {
		return resourceService.addCourses(courseList);
	}

	@ApiOperation(value = "Get list of Students in the System ", response = Iterable.class, tags = "getStudents")
	@ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "not authorized!"),
	            @ApiResponse(code = 403, message = "forbidden!!!"),
	            @ApiResponse(code = 404, message = "not found!!!") })
	@PutMapping("/courses/{id}")
	public void updateCourse(@PathVariable("id") final int id, @RequestBody final Course course) {
		resourceService.updateCourse(id, course);
	}

	@ApiOperation(value = "Get list of Students in the System ", response = Iterable.class, tags = "getStudents")
	@ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "not authorized!"),
	            @ApiResponse(code = 403, message = "forbidden!!!"),
	            @ApiResponse(code = 404, message = "not found!!!") })
	@DeleteMapping("/courses/{id}")
	public void deleteCourse(@PathVariable("id") final int id) {
		resourceService.deleteCourse(id);
	}
	
}
