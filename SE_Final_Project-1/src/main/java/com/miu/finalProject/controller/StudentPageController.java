package com.miu.finalProject.controller;

import com.miu.finalProject.domain.Course;
import com.miu.finalProject.domain.Faculty;
import com.miu.finalProject.service.CourseService;
import com.miu.finalProject.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/studentpage")
public class StudentPageController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private FacultyService facultyService;
    @GetMapping("/courseList")
    public String listCourse(Model model){
        List<Course> courses = courseService.findAll();
        model.addAttribute("courses",courses);
        return "students/list-courses";
    }
    @GetMapping("/seecourses")
    public String seeCourses(Model model){
//        List<Course> courses = courseService.findAll();
//        model.addAttribute("courses",courses);
        return "students/studentPage";
    }
    @GetMapping("/facultyList")
    public String facultyList(Model model){
         List<Faculty> faculties = facultyService.findAll();
        //model.addAttribute("faculties",faculties );
        return "faculty/addsucess";
    }
}
