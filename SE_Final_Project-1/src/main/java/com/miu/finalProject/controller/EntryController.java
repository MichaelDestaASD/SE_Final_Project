package com.miu.finalProject.controller;

import com.miu.finalProject.domain.Entry;
import com.miu.finalProject.service.EntryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/entries")
public class EntryController {

    @Autowired
    EntryService entryService;

    @GetMapping("Entrylist")
    public String listEntry(Model model){
        List<Entry> entries = entryService.findAll();
        model.addAttribute("entries",entries);
        return "entry/list-entries";
    }

    @RequestMapping("/AddEntry")
    public String showFormEntry(Model model){
        Entry theEntry = new Entry();
        model.addAttribute("entry",theEntry);
        return "entry/entry-form";
    }

    @PostMapping("/save")
    public String saveEntry(@ModelAttribute("entry") Entry entry){
        entryService.save(entry);
        return "redirect:/entries/Entrylist";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("entryId") int Id){
        entryService.deleteById(Id);
        return "redirect:/entries/Entrylist";
    }
     @GetMapping("/update")
    public String update(@RequestParam("entryId") int Id, Model model){
        Entry entry= entryService.findById(Id);
        model.addAttribute("entry",entry);
        return "entry/entry-form";
    }
}
