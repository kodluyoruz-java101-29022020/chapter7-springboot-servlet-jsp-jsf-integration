package com.integrator.common.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.integrator.jsf.repository.EmployeeRepository;
import com.integrator.jsp.controller.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	@Qualifier("employeeHibernateRepository")
	private EmployeeRepository employeeRepository;
	
	
	public List<String> getEmployeeNameList() {
		
		return Arrays.asList("Ahmet", "Ayşe", "Mehmet", "Fatma");
	}
	
	public List<com.integrator.jsf.dao.entity.Employee> getEmployees() {
		
		return employeeRepository.getAllEmployeeList();
	}
	
	public void save(Employee emp) {
		
		Long maxId = employeeRepository.findMaxId();
		
		com.integrator.jsf.dao.entity.Employee employee = new com.integrator.jsf.dao.entity.Employee();
		employee.setEmpNo(maxId);
		employee.setName(emp.getName());
		employee.setLastName(emp.getLastName());
		employee.setGender(emp.getGender());
		employee.setBirthDate(emp.getBirthDate());
		employee.setHireDate(emp.getHireDate());
		
		employeeRepository.save(employee);
	}
	
	public com.integrator.jsf.dao.entity.Employee findById(Long empId) {
		
		return employeeRepository.findWithEmpNo(empId);
	}
}
