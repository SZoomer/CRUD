package com.view.CRUD.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.view.CRUD.model.Faculty;
import com.view.CRUD.repository.FacultyRepository;

@Service
public class FacultyServiceImpl implements FacultyService{

	@Autowired
	private FacultyRepository facRepo;
	
	@Override
	public void addFaculty(Faculty faculty) {
		facRepo.save(faculty);
		
	}	
	  @Override 
	  public void deleteFaculty(int id) { 
		  facRepo.deleteById(id);
	  
	  }
	  
	  @Override 
	  public List<Faculty> getAllFaculty() { 
		  return facRepo.findAll(); }
	  
	  @Override 
	  public Faculty getFacultyById(int id) { 
		  return facRepo.getById(id);
	  }
	  
	  @Override 
	  public void updateFaculty(Faculty faculty) { 
		  facRepo.save(faculty);
	 
	 }
	 
	
	
	
	

}
