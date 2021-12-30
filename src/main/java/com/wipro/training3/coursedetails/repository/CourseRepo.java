package com.wipro.training3.coursedetails.repository;

import org.springframework.stereotype.Repository;

import com.wipro.training3.coursedetails.entity.Course;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CourseRepo extends JpaRepository<Course,Long>{
	List<Course> findAll();
	Course save(Course course);
}
