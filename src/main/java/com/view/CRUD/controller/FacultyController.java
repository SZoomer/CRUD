package com.view.CRUD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.view.CRUD.model.Faculty;
import com.view.CRUD.repository.FacultyRepository;

@Controller
public class FacultyController {
	
	@Autowired
	private FacultyRepository facRepo;

	@GetMapping("/facultyform")
	public String showFacultyForm() {

		return "FacultyForm";
	}

	@PostMapping("/facultyform")
	public String saveFaculty(@ModelAttribute Faculty faculty) {

		facRepo.save(faculty);

		return "redirect:/facultylist";
	}
		
	@GetMapping("/facultylist") 
	public String facultyList(Model model) {
		  
	model.addAttribute("facultylist", facRepo.findAll());
		  
	return "FacultyList"; 
		}	  
		  
	@GetMapping("/delete") 
	public String deleteFaculty(@RequestParam int id) {
		  
	facRepo.deleteById(id);
		  
	return "redirect:facultylist"; 
	 }
		  
	 @GetMapping("/edit") 
	public String editFaculty(@RequestParam int id, Model model) {
		  
	model.addAttribute("emodel",facRepo.getById(id));
		  
	return "EditForm"; 
	}
		  
	@PostMapping("/update") 
	public String updateFaculty(@ModelAttribute Faculty faculty) {
		  
	facRepo.save(faculty);
		 
	return "redirect:/facultylist"; 
		 
	}
	
	

}
