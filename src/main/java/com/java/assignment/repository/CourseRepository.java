package com.java.assignment.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.assignment.modal.Course;


/**
 * Repository for Course
 * JPA Implementation
 * 
 * @author AbhishekK
 *
 */
public interface CourseRepository extends JpaRepository<Course, Integer> {

	Optional<Course> findByName(String name);

}
