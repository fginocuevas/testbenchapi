package com.thenogicode.testbenchapi.repositories;

import com.thenogicode.testbenchapi.models.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
}
