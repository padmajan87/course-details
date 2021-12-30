package com.wipro.training3.coursedetails.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.training3.coursedetails.entity.Course;
import com.wipro.training3.coursedetails.service.CourseService;

@RestController
public class CourseController {

	private CourseService courseSer;
	
	public CourseController(CourseService courseSer) {
		this.courseSer = courseSer;
	}
	
	@PreAuthorize("hasAuthority('USER')")
	@GetMapping(value = "/courses",produces = { "application/json" })
	public List<Course> getCourses(){
		List<Course> courses = courseSer.getCourses();
		return courses;
	}
	
	@PreAuthorize("hasAuthority('INSTRUCTOR')")
	@PostMapping("/courses")
	public Course addCoourse(@RequestBody Course course) {
		Course courseAdded = courseSer.addCourse(course);
		return courseAdded;
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@PutMapping("/Courses/{coursePrice}/{id}")
	public Course updateCourse(@PathVariable("coursePrice") String coursePrice, 
			@PathVariable("id") Long id) {
		Course updatedCourse = courseSer.modifyCourse(coursePrice, id);
		return updatedCourse;
	}
}
