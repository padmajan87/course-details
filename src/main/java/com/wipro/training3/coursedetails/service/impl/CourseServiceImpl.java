package com.wipro.training3.coursedetails.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wipro.training3.coursedetails.entity.Course;
import com.wipro.training3.coursedetails.repository.CourseRepo;
import com.wipro.training3.coursedetails.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	private CourseRepo courseRepo;
	
	public CourseServiceImpl(CourseRepo courseRepo) {
		this.courseRepo = courseRepo;
	}
	
	@Override
	public List<Course> getCourses() {
		List<Course> courses = courseRepo.findAll();
		return courses;
	}

	@Override
	public Course addCourse(Course course) {
		Course courseAdded = courseRepo.save(course);
		return courseAdded;
	}

	@Override
	public Course modifyCourse(String coursePrice, Long courseId) {
		Course course = getCourseById(courseId);
		Double price = Double.valueOf(coursePrice);
		course.setPrice(price);
		Course coursewithNewPrice = addCourse(course);
		return coursewithNewPrice;
	}

	@Override
	public Course getCourseById(Long courseId) throws RuntimeException{
		Course course = courseRepo.findById(courseId)
				                 .orElseThrow(() -> new RuntimeException("Course not found"));
		return course;
	}

}
