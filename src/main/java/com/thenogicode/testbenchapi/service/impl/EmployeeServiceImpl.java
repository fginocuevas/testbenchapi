package com.thenogicode.testbenchapi.service.impl;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.thenogicode.testbenchapi.models.Employee;
import com.thenogicode.testbenchapi.repositories.EmployeeRepository;
import com.thenogicode.testbenchapi.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Set<Employee> findAll() {
		Set<Employee> employees= new LinkedHashSet<Employee>();
		employeeRepository.findAll().forEach(employees :: add);
		return employees;
	}

	@Override
	public Employee findById(Long id) {
		Optional<Employee> doctor= employeeRepository.findById(id);
		return doctor.orElse(null);
	}

	@Override
	public void delete(Employee object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee save(Employee object) {
		return employeeRepository.save(object);
	}

}
