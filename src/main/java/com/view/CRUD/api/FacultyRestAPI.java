package com.view.CRUD.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.view.CRUD.model.Faculty;
import com.view.CRUD.repository.FacultyRepository;

@RestController
@RequestMapping("/api/faculty")
public class FacultyRestAPI {
	
	@Autowired
	private FacultyRepository facRepo;
	
	@GetMapping("/facultylist")
	public List<Faculty> getAllFaculty(){
		
		return facRepo.findAll();
	}
	
	@PostMapping("/addFaculty")
	public String addFaculty(@RequestBody Faculty faculty) {
		
		facRepo.save(faculty);
		return "Faculty Added";
	}
	
	@PostMapping("/update") 												//------PutMapping is for Update in API
	public String updateFaculty(@RequestBody Faculty faculty) {
		  
		facRepo.save(faculty);
		 
		return "Update Successfully"; 
		 
	}
	
	@DeleteMapping("/delete/{id}") 
	public String deleteFaculty(@PathVariable int id) {							// --------- For API
		  
		facRepo.deleteById(id);
		  
		return "Faculty Deleted."; 
	 }
	@SuppressWarnings("deprecation")
	@GetMapping("/{id}")
	public Faculty getOneFaculty(@PathVariable int id) {
		
		return facRepo.getById(id);
		
	}
	@GetMapping("/JSONtoObject")
	public String convertJSONToObject() {									//Converting JSON to Object (for Single Data) 
		
		RestTemplate temp = new RestTemplate();
		Faculty f1 = temp.getForObject("http://localhost/api/faculty/3", Faculty.class);
		
		return "Faculty Name = " +f1.getFname();
	}
	
	@GetMapping("/JSONtoObjectAll")
	public String convertJSONArrayToObjectArray() {							//Converting JSON to Object (for Multiple Data)
		
		RestTemplate temp = new RestTemplate();
		Faculty[] facultylist = temp.getForObject("http://localhost/api/faculty/facultylist", Faculty[].class);
		
		return "Faculty Name = " +facultylist[0].getFname();
	}


}
