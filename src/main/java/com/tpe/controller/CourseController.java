package com.tpe.controller;

import com.tpe.domain.Course;
import com.tpe.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

//@RequestMapping
////This annotation is used to map HTTP requests to specific methods in a controller
//The @RequestMapping annotation can be applied at both the class and method level in Spring.
//@RestController// this annotation that combine  @Controller and  @responseBody

//class level to define a default mapping for all methods in the class,
// Method  level :specifies the URI path and HTTP method for handling a specific Method.
@Controller
//@RestController  //this annotation that combine @Controller and @ResponseBody
@RequestMapping("/courses")  //request started with "/course" end point will be handled here ///http://localhost:8080/SpringMVC/course

public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/form")
    public String showCourseForm(@ModelAttribute("course") Course course){
        return "courseForm";
    }
}
