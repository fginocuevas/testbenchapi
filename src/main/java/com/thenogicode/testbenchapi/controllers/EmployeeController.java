package com.thenogicode.testbenchapi.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.thenogicode.testbenchapi.models.Employee;
import com.thenogicode.testbenchapi.repositories.EmployeeRepository;
import com.thenogicode.testbenchapi.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
//@Profile("localdev")
@Slf4j
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee employee) {
		log.info("MCI >> findPostEmployee");
		return employeeService.save(employee);
	}
	
	@PostMapping("/findEmployee")
	public ResponseEntity<?> findPostEmployee() {
		log.info("MCI >> findPostEmployee");
		
		Employee employee = Employee.builder().firstName("Cloud")
				.lastName("Strife")
				.password("Final Fantasy").build();
		ResponseEntity<?> response= null;
		
	    if (employee == null) {
	    	response= ResponseEntity.notFound().build();
	    } else {
	        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
	          .path("/{id}")
	          .buildAndExpand(employee.getId())
	          .toUri();
	        
	        response= ResponseEntity.created(uri)
	          .body(employee);
	    }
	    
	    log.info("MCO >> findPostEmployee");
	    return response;
	}
	
	@PostMapping("/findAll")
	public Set<Employee> findAll(){
		return employeeService.findAll();
	}
	
	@GetMapping("/findListString")
	public ResponseEntity<List<String>> findListString() {
		System.out.println("findListString");
		List<String> list= new ArrayList<String>();
		list.add("Gino");
		list.add("Janpat");
		list.add("Tricia");
		return new ResponseEntity<>(list, HttpStatus.OK);
	};
	
//	@GetMapping("/findEmployee")
//	public ResponseEntity<?> findEmployee() {
//		System.out.println("Hello World!");
//		
//		Employee employee = Employee.builder().firstName("Cloud")
//				.lastName("Strife")
//				.password("Final Fantasy").build();
//		
//	    if (employee == null) {
//	        return ResponseEntity.notFound().build();
//	    } else {
//	        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
//	          .path("/{id}")
//	          .buildAndExpand(employee.getId())
//	          .toUri();
//	 
//	        return ResponseEntity.created(uri)
//	          .body(employee);
//	    }
//	}
	
}


