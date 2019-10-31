package com.java.assignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.java.assignment.modal.Course;
import com.java.assignment.modal.Stream;
import com.java.assignment.repository.CourseRepository;
import com.java.assignment.repository.StreamRepository;

@Service
public class ResourceService {
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	StreamRepository streamRepository;
	
//	@GetMapping("/courses")
//	public List<Course> searchCourses(@RequestParam(value="name") String courseName, streamName) {
//		if(name == null || name.isEmpty()) {
//			return courseRepository.findAll();			
//		}else {
//			List<Course> courseList = new ArrayList<Course>();
//			courseList.add(getCourseByName(name));
//			return courseList;
//		}
//
//	}
	
	public List<Course> getAllCourses() {
		return courseRepository.findAll();

	}
	
	public Course getCourseByName(final String name) {
		Optional<Course> course = courseRepository.findByName(name);
		if (course.isPresent()) {
			return course.get();
		} else {
			return (new Course());
		}
	}

	public Course getCourseById(int id) {
		Optional<Course> course = courseRepository.findById(id);
		if (course.isPresent()) {
			return course.get();
		} else {
			return (new Course());
		}
	}

	public List<Course> addCourses( List<Course> courseList) {
		for (Course c : courseList) {
			courseRepository.save(c);
		}
		return getAllCourses();
	}

	public void updateCourse(int id, Course course) {
		Course oldCourse = getCourseById(id);
		oldCourse.setCode(course.getCode());
		oldCourse.setName(course.getName());
		courseRepository.save(oldCourse);
	}

	public void deleteCourse(int id) {
		courseRepository.delete(getCourseById(id));
	}


	public List<Stream> getAllStream() {
		return streamRepository.findAll();
	}


	public Stream getStreamById(int id) {
		Optional<Stream> stream = streamRepository.findById(id);
		if (stream.isPresent()) {
			return stream.get();
		} else {
			return (new Stream());
		}
	}

	public List<Stream> addStream(List<Stream> stream) {
		for(Stream s: stream) {
			streamRepository.save(s);
		}
		return getAllStream();
	}


	public Stream updateStream( int id,Stream stream) {
		Stream oldStream = getStreamById(id);
		oldStream.setCode(stream.getCode());
		oldStream.setName(stream.getName());
		return streamRepository.save(oldStream);
	}


	public void deleteStream(int id) {
		streamRepository.delete(getStreamById(id));
	}
	
	public void addStreamCourses( List<Course> course,int id) {
		Stream stream = getStreamById(id);
		for(Course c: course) {
			stream.getCourses().add(c);
		}
		streamRepository.save(stream);
	}

}
