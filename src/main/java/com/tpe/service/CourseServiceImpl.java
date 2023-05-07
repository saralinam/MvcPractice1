package com.tpe.service;

import com.tpe.domain.Course;
import com.tpe.exception.ResourceNotFoundException;
import com.tpe.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;


    @Override
    public void saveCourse(Course course) {
        courseRepository.saveCourse(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.getAllCourses();
    }

    @Override
    public Course findCourseById(Long id) {
        Course course = courseRepository.findCourseById(id).orElseThrow(()->new ResourceNotFoundException("Resource not found with id: "+id));
        return course;
    }
}
