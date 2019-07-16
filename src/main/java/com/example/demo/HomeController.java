package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;

    @RequestMapping("/")
    public String index(Model model){

        Student student= new Student();
        student.setFirstName("Dan");
        student.setLastName("Green");
        student.setAge(25);

        Course course = new Course();
        course.setTitle("Java101");
        course.setInstructor("Dr.J");
        course.setCredits(3);


        Set<Course> courses = new HashSet<Course>();
        courses.add(course);

        student.setCourses(courses);

        studentRepository.save(student);

        model.addAttribute("students", studentRepository.findAll());
        return "index";
    }
}
