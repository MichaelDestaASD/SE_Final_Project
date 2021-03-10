package com.miu.finalProject.controller;


import com.miu.finalProject.domain.Course;
import com.miu.finalProject.domain.Faculty;
import com.miu.finalProject.service.CourseService;

import com.miu.finalProject.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

//@RestController
@Controller
@RequestMapping("/courses")
public class CourseController {

    private List<Course> theCourse;



    @Autowired
    CourseService courseService;
    @Autowired
    FacultyService facultyService;


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
        List<Faculty> faculties = facultyService.findAll();
        System.out.println("_____________"+ faculties.get(0).getEmail());
        model.addAttribute("faculties",faculties);
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
        List<Faculty>facultyList=facultyService.findAll();
        model.addAttribute("faculties",facultyList);
        model.addAttribute("course", course);
        return "course/course-form";
    }

}
