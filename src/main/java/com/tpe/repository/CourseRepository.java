package com.tpe.repository;

import com.tpe.domain.Course;

import java.util.List;
import java.util.Optional;

public interface CourseRepository {

    void saveCourse(Course course);

    List<Course> getAllCourses();

    Optional<Course> findCourseById(Long id);

}
