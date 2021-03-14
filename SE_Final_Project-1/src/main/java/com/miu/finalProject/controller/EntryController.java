package com.miu.finalProject.controller;

import com.miu.finalProject.domain.*;
import com.miu.finalProject.service.BlockServiceInterface;
import com.miu.finalProject.service.CourseService;
import com.miu.finalProject.service.EntryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/entries")
public class EntryController {

    @Autowired
    EntryService entryService;
    @Autowired
    BlockServiceInterface blockServiceInterface;
    @Autowired
    CourseService courseService;

    @GetMapping("list")
    public String listEntry(Model model){
        List<Entry> entries = entryService.findAll();
        model.addAttribute("entries",entries);
        return "entry/list-entries";
    }

    @RequestMapping("/AddEntry")
    public String showFormEntry(Model model){
        Entry theEntry = new Entry();
        List<Block> blocks = blockServiceInterface.findAll();

        model.addAttribute("blocks", blocks);
        model.addAttribute("entry",theEntry);
        return "entry/entry-form";
    }

    @PostMapping("/save")
    public String saveEntry(@ModelAttribute("entry") Entry entry){
        entryService.save(entry);
        return "redirect:/entries/list";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("entryId") int Id){
        entryService.deleteById(Id);
        return "redirect:/entries/list";
    }
     @GetMapping("/update")
    public String update(@RequestParam("entryId") int Id, Model model){
        Entry entry= entryService.findById(Id);
        model.addAttribute("entry",entry);
        return "entry/entry-form";
    }
    @GetMapping("/blocks/{entryid}")
    public String getCourses(Model model, @PathVariable Long entryid) {
        Entry entry = entryService.findById(entryid);
        System.out.println("entry.................." + entry);
        model.addAttribute("entry", entry);
//        model.addAttribute("faculties", facultyService.findById(courseid));
        return "entry/block-list";
    }
}
