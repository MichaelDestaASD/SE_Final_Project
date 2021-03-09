package com.miu.finalProject.controller;


import com.miu.finalProject.domain.Course;
import com.miu.finalProject.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

//@RestController
@Controller
@RequestMapping("/courses")
public class CourseController {

    private List<Course> theCourse;



    @Autowired
    CourseService courseService;


    @GetMapping("/list")
    public String listCourse(Model model){
        List<Course> courses = courseService.findAll();
        model.addAttribute("courses",courses);
        return "course/list-courses";
    }
//    @GetMapping("/list1")
//    public List<Course> listCourse1(){
//        List<Course> courses = courseService.findAll();
//       // model.addAttribute("courses",courses);
//        return courses;
//    }

    @RequestMapping("/showFormForAdd")
    public String showForm(Model model){
        Course theCourse = new Course();
        model.addAttribute("course", theCourse);
          return "course/course-form";
    }

    @PostMapping("/save")
    public String saveCourse(@ModelAttribute("course") Course course){
        courseService.save(course);
        return "redirect:/courses/list";
    }



    @GetMapping("/delete")
    public String delete(@RequestParam("courseId") int Id){
        courseService.deleteById(Id);
        return "redirect:/courses/list";
    }
    @GetMapping("/update")
    public String update(@RequestParam("courseId") int Id, Model model){
        Course course = courseService.findById(Id);
        model.addAttribute("course", course);
        return "course/course-form";
    }

}
