package com.wipro.training3.coursedetails.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CourseModule {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long courseDetailsId;
  private String moduleName;
  private String moduleUrl;
  
//  @ManyToOne
//  private Course course;
  
public Long getCourseDetailsId() {
	return courseDetailsId;
}
public void setCourseDetailsId(Long courseDetailsId) {
	this.courseDetailsId = courseDetailsId;
}
public String getModuleName() {
	return moduleName;
}
public void setModuleName(String moduleName) {
	this.moduleName = moduleName;
}
public String getModuleUrl() {
	return moduleUrl;
}
public void setModuleUrl(String moduleUrl) {
	this.moduleUrl = moduleUrl;
}
}
