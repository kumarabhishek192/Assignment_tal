package com.java.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.assignment.modal.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{

}
