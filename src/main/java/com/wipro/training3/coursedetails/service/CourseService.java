package com.wipro.training3.coursedetails.service;

import java.util.List;

import com.wipro.training3.coursedetails.entity.Course;

public interface CourseService {
  List<Course> getCourses();
  Course addCourse(Course course);
  Course modifyCourse(String coursePrice, Long courseId);
  Course getCourseById(Long courseId);
}
