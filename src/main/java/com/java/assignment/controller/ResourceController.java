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
@Api(value = "Admin Controller", description = "REST API for Admin Controller")
public class ResourceController {

	/**
	 * Injection of Service Object
	 */
	@Autowired
	ResourceService resourceService;
	
	/**
	 * GET/Streams
	 * Get list of all Streams in the admin System
	 * @return List<Stream>
	 */
	@ApiOperation(value = "Get list of all Streams in the admin System ", response = Iterable.class, tags = "getAllStreams")
	@ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "not authorized!"),
	            @ApiResponse(code = 403, message = "forbidden!!!"),
	            @ApiResponse(code = 404, message = "not found!!!") })
	@GetMapping("/streams")
	public List<Stream> getAllStream() {
		return resourceService.getAllStream();
	}

	
	/**
	 * GET/streams/id
	 * Get Stream with given id in the admin System 
	 * @param id of stream
	 * @return Stream
	 */
	@ApiOperation(value = "Get Stream with given id in the admin System ", response = Stream.class, tags = "getStudents")
	@ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "not authorized!"),
	            @ApiResponse(code = 403, message = "forbidden!!!"),
	            @ApiResponse(code = 404, message = "not found!!!") })
	@GetMapping("/stream/{id}")
	public Stream getStreamById(@PathVariable("id") final int id) {
		return resourceService.getStreamById(id);
	}

	
	/**
	 * POST/Stream
	 * Add list of streams in the admin System 
	 * @param stream Object
	 * @return List<Stream>
	 */
	@ApiOperation(value = "Add list of streams in the admin System ", response = Iterable.class, tags = "getStudents")
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
	 * PUT/Stream/id
	 * Update stream using stream id in the admin System 
	 * @param id of stream
	 * @param stream object
	 * @return Stream.class
	 */
	@ApiOperation(value = "Update stream using stream id in the admin System ", response = Stream.class, tags = "getStudents")
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
	 * DELETE/Stream/id
	 * Delete Stream from the database
	 * @param id for deleting by id
	 * @return list of rest stream
	 */
	@ApiOperation(value = "Delete stream by id in the admin System ", response = void.class, tags = "getStudents")
	@ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "not authorized!"),
	            @ApiResponse(code = 403, message = "forbidden!!!"),
	            @ApiResponse(code = 404, message = "not found!!!") })
	@DeleteMapping("/streams/{id}")
	public void deleteStream(@PathVariable("id") final int id) {
		resourceService.deleteStream(id);
	}
	
	/**
	 * POST/Stream/id/course
	 * Add courses to the stream in the admin System 
	 * @param course object
	 * @param id of Stream
	 */
	@ApiOperation(value = "Add courses to the stream in the admin System ", response = void.class, tags = "getStudents")
	@ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "not authorized!"),
	            @ApiResponse(code = 403, message = "forbidden!!!"),
	            @ApiResponse(code = 404, message = "not found!!!") })
	@PostMapping("/streams/{id}/courses")
	public void addStreamCourses(@RequestBody final List<Course> course,@PathVariable("id") final int id) {
		resourceService.addStreamCourses(course, id);
	}
	
	
	/**
	 * GET/Course
	 * Get all courses in the admin System
	 * @return List<Course>
	 */
	@ApiOperation(value = "Get all courses in the admin System ", response = Iterable.class, tags = "getStudents")
	@ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "not authorized!"),
	            @ApiResponse(code = 403, message = "forbidden!!!"),
	            @ApiResponse(code = 404, message = "not found!!!") })
	@GetMapping("/courses")
	public List<Course> getAllCourses() {
		return resourceService.getAllCourses();

	}

	
	/**
	 * GET/Course/name
	 * Get course by name in the admin System 
	 * @param name of the course
	 * @return Course.class
	 */
	@ApiOperation(value = "Get course by name in the admin System ", response = Iterable.class, tags = "getStudents")
	@ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "not authorized!"),
	            @ApiResponse(code = 403, message = "forbidden!!!"),
	            @ApiResponse(code = 404, message = "not found!!!") })
	@GetMapping("/courses/name/{name}")
	public Course getCourseByName(final String name) {
		return resourceService.getCourseByName(name);
	}

	
	/**
	 * GET/Course/id
	 * Get course by id in the admin System 
	 * @param id of course
	 * @return Course.class
	 */
	@ApiOperation(value = "Get course by id in the admin System ", response = Iterable.class, tags = "getStudents")
	@ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "not authorized!"),
	            @ApiResponse(code = 403, message = "forbidden!!!"),
	            @ApiResponse(code = 404, message = "not found!!!") })
	@GetMapping("/courses/{id}")
	public Course getCourseById(@PathVariable("id") final int id) {
		return resourceService.getCourseById(id);
	}

	
	/**
	 * POST/Course
	 * Add course in the admin System 
	 * @param courseList list of course
	 * @return List<Course>
	 */
	@ApiOperation(value = "Add course in the admin System ", response = Iterable.class, tags = "getStudents")
	@ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "not authorized!"),
	            @ApiResponse(code = 403, message = "forbidden!!!"),
	            @ApiResponse(code = 404, message = "not found!!!") })
	@PostMapping("/courses")
	public List<Course> addCourses(@RequestBody final List<Course> courseList) {
		return resourceService.addCourses(courseList);
	}

	
	/**
	 * PUT/Course/id
	 * Update course by id in the admin System 
	 * @param id of course
	 * @param course object
	 */
	@ApiOperation(value = "Update course by id in the admin System ", response = Iterable.class, tags = "getStudents")
	@ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "not authorized!"),
	            @ApiResponse(code = 403, message = "forbidden!!!"),
	            @ApiResponse(code = 404, message = "not found!!!") })
	@PutMapping("/courses/{id}")
	public void updateCourse(@PathVariable("id") final int id, @RequestBody final Course course) {
		resourceService.updateCourse(id, course);
	}

	
	/**
	 * DELETE/Course/id
	 * Delete course by id in the admin System
	 * @param id of course
	 */
	@ApiOperation(value = "Delete course by id in the admin System ", response = Iterable.class, tags = "getStudents")
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
