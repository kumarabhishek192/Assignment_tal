package com.java.assignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.java.assignment.modal.Course;
import com.java.assignment.modal.Stream;
import com.java.assignment.repository.CourseRepository;
import com.java.assignment.repository.StreamRepository;


/**
 * Service Class
 * @author AbhishekK
 *
 */
@Service
public class ResourceService {
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	StreamRepository streamRepository;
	
	/**
	 * 
	 */
	public List<Course> getAllCourses() {
		return courseRepository.findAll();

	}
	
	/**
	 * 
	 */
	public Course getCourseByName(final String name) {
		Optional<Course> course = courseRepository.findByName(name);
		if (course.isPresent()) {
			return course.get();
		} else {
			return (new Course());
		}
	}

	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Course getCourseById(int id) {
		Optional<Course> course = courseRepository.findById(id);
		if (course.isPresent()) {
			return course.get();
		} else {
			return (new Course());
		}
	}

	
	/**
	 * 
	 * @param courseList
	 * @return
	 */
	public List<Course> addCourses( List<Course> courseList) {
		for (Course c : courseList) {
			courseRepository.save(c);
		}
		return getAllCourses();
	}

	
	/**
	 * 
	 * @param id
	 * @param course
	 */
	public void updateCourse(int id, Course course) {
		Course oldCourse = getCourseById(id);
		oldCourse.setCode(course.getCode());
		oldCourse.setName(course.getName());
		courseRepository.save(oldCourse);
	}

	
	/**
	 * 
	 * @param id
	 */
	public void deleteCourse(int id) {
		courseRepository.delete(getCourseById(id));
	}


	/**
	 * 
	 * @return
	 */
	public List<Stream> getAllStream() {
		return streamRepository.findAll();
	}


	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Stream getStreamById(int id) {
		Optional<Stream> stream = streamRepository.findById(id);
		if (stream.isPresent()) {
			return stream.get();
		} else {
			return (new Stream());
		}
	}

	
	/**
	 * 
	 * @param stream
	 * @return
	 */
	public List<Stream> addStream(List<Stream> stream) {
		for(Stream s: stream) {
			streamRepository.save(s);
		}
		return getAllStream();
	}


	
	/**
	 * 
	 * @param id
	 * @param stream
	 * @return
	 */
	public Stream updateStream( int id,Stream stream) {
		Stream oldStream = getStreamById(id);
		oldStream.setCode(stream.getCode());
		oldStream.setName(stream.getName());
		return streamRepository.save(oldStream);
	}


	
	/**
	 * 
	 * @param id
	 */
	public void deleteStream(int id) {
		streamRepository.delete(getStreamById(id));
	}
	
	
	/**
	 * 
	 * @param course
	 * @param id
	 */
	public void addStreamCourses( List<Course> course,int id) {
		Stream stream = getStreamById(id);
		for(Course c: course) {
			stream.getCourses().add(c);
		}
		streamRepository.save(stream);
	}

}
