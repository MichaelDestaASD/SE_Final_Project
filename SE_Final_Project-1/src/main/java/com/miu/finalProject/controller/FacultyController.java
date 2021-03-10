package com.miu.finalProject.controller;

import com.miu.finalProject.domain.Faculty;
import com.miu.finalProject.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/faculty")
public class FacultyController {

    @Autowired
    FacultyService facultyService;

    @GetMapping("/")
    public String assignFaculty(@ModelAttribute("faculty") Faculty faculty, Model model){

        List<Faculty> faculties1 = facultyService.findAll();

        model.addAttribute("faculty",faculties1);


        return "/Faculty/addsucess";

    }
    @RequestMapping("/assignFaculty")
    public String addFaculty(@ModelAttribute("faculty") Faculty faculty,Model model){

        model.addAttribute("faculty",faculty);
        return "/Faculty/assign";
    }
    @PostMapping("/save")
    public String saveCourse(@ModelAttribute("faculty") Faculty faculty){
        facultyService.save(faculty);
        return "redirect:/faculty/";
    }
    @GetMapping("/update")
    public String update(@RequestParam("facultyID") Long Id, Model model){
        Optional<Faculty> faculty = facultyService.findById(Id);
        model.addAttribute("faculty", faculty);
        return "/Faculty/assign";
    }

    @RequestMapping("/deleteFaculty")
    public String deleteFaculty(@RequestParam("facultyID")Long id){

        facultyService.deleteById(id);


        return "redirect:/faculty/";

    }

}
