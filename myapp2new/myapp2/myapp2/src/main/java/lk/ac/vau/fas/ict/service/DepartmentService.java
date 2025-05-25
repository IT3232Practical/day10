package lk.ac.vau.fas.ict.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import lk.ac.vau.fas.ict.model.Department;
import lk.ac.vau.fas.ict.repo.DepartmentRepo;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepo repo;


public List<Department> getDepts() {
	return repo.findAll();
}
public Department getDept(int id) {
if(repo.findById(id).isEmpty()) {
	throw new EntityNotFoundException("Department not found");
}	
return repo.findById(id).get();
}
public String addDept(Department department) {
	if(repo.findById(department.getId()).isPresent()) {
		throw new DuplicateKeyException("The department is already available");
	}
	repo.save(department);
	return "New department added";
	
}

}
