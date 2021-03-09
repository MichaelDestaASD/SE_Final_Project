package com.miu.finalProject.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.miu.finalProject.domain.Section;
import com.miu.finalProject.service.SectionService;

@Controller
@RequestMapping("/sections")
public class SectionController {
	private SectionService sectionService;

	public SectionController(SectionService sectionService) {
		super();
		this.sectionService = sectionService;
	}

	@GetMapping("/list")
	public String listSections(Model theModel) {

		// get student from db
		List<Section> sections = sectionService.findAll();

		// add to the spring model
		theModel.addAttribute("sections", sections);

		return "sections/list-sections";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Section section = new Section();

		theModel.addAttribute("section", section);

		return "sections/section-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("sectionId") int Id, Model theModel) {

		// get the student from the service
		Section section = sectionService.findById(Id);

		// set student as a model attribute to pre-populate the form
		theModel.addAttribute("section", section);

		// send over to our form
		return "sections/section-form";
	}

	@PostMapping("/save")
	public String saveSection(@ModelAttribute("section") Section section) {

		// save the student
		sectionService.save(section);

		// use a redirect to prevent duplicate submissions
		return "redirect:/sections/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("sectionId") int Id) {

		// delete the student
		sectionService.deleteById(Id);

		// redirect to /students/list
		return "redirect:/sections/list";

	}
}
