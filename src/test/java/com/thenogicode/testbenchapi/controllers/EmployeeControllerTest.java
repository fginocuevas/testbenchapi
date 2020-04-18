package com.thenogicode.testbenchapi.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = {EmployeeController.class})
class EmployeeControllerTest {
	
	@Autowired
    private MockMvc mvc;

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("EmployeeControllerTest.setUp");
	}

	//@Test
	void testFindEmployee() throws Exception{
		System.out.println("EmployeeControllerTest.testFindEmployee");
		mvc.perform(get("/api/employees")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk());
	}

}