package com.wipro.training3.coursedetails.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Course extends BaseEntity{
	
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 private Long id;
 private String name;
 private double price;
 private String author;
 
 @OneToMany(cascade=CascadeType.ALL)
 private List<CourseModule> courseModules = new ArrayList();

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public double getPrice() {
	return price;
}

public void setPrice(double price) {
	this.price = price;
}

public String getAuthor() {
	return author;
}

public void setAuthor(String author) {
	this.author = author;
}

public List<CourseModule> getCourseModules() {
	return courseModules;
}

public void setCourseModules(List<CourseModule> courseModules) {
	this.courseModules = courseModules;
}
 
 
}
