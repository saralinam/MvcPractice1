package com.tpe.repository;

import com.tpe.domain.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepositoryImpl implements CourseRepository {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void saveCourse(Course course) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(course);
        tx.commit();
        session.close();
    }

    @Override
    public List<Course> getAllCourses() {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<Course> courseList = session.createQuery("FROM Course", Course.class).getResultList();
        tx.commit();
        session.close();
        return courseList;
    }

    @Override
    public Optional<Course> findCourseById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Course course = session.get(Course.class, id);
        Optional<Course> optionalCourse = Optional.ofNullable(course);
        tx.commit();
        session.close();
        return optionalCourse;
    }
}
