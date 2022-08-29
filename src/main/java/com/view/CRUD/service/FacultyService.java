package com.view.CRUD.service;

import java.util.List;

import com.view.CRUD.model.Faculty;

public interface FacultyService {
	
void addFaculty(Faculty faculty);
	

  void deleteFaculty(int id);
  
  List<Faculty> getAllFaculty();
  
  Faculty getFacultyById(int id);
 
  void updateFaculty(Faculty faculty);
 

	
}
