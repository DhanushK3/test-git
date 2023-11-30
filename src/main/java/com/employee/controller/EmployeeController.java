package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

	
	// build create employee REST API
	// @request body => allows to retrive the request body and automatically convert it in to java object
	// REST API create resourse so we created httpstatus
	@PostMapping()
	public ResponseEntity<Employee> saveEmployee (@RequestBody Employee employee ){
		 if (employee != null) {
		        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
		    } else {
		        // Handle the case when the request body is null
		        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		    }
		
		
	}

}
