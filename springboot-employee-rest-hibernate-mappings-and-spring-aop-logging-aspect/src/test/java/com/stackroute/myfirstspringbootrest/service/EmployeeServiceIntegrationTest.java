package com.stackroute.myfirstspringbootrest.service;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.stackroute.myfirstspringbootrest.exceptions.EmployeeWithIDAlreadyPresentException;
import com.stackroute.myfirstspringbootrest.exceptions.EmployeeWithTheIDNotPresentException;
import com.stackroute.myfirstspringbootrest.model.Employee;

@SpringBootTest
public class EmployeeServiceIntegrationTest {
	
	
	@Autowired
	private EmployeeService employeeService;
	
	@Test
	public void testingGetEmployeeByIdForValidEmployee() throws EmployeeWithTheIDNotPresentException, EmployeeWithIDAlreadyPresentException {
		
		Employee employee = new Employee(506, "Deepan", 5000, LocalDate.of(2016, 9, 9));
		employeeService.addNewEmployee(employee);
		
		int input = 506;
		
		Employee actual = employeeService.getEmployeeById(input); 
		Assertions.assertNotNull(actual,"should return the employee object for valid employee");
		Assertions.assertEquals(actual.getId(), 506,"id of actual employee object and the expected should be equal for valid employee");
	}
	
	@Test
	public void testingAddNewEmployeeWithNewEmployee() throws EmployeeWithIDAlreadyPresentException, EmployeeWithTheIDNotPresentException {
		
		Employee employee = new Employee(400, "Deepan", 5000, LocalDate.of(2016, 9, 9));
		
		Assertions.assertThrows(EmployeeWithTheIDNotPresentException.class, ()->{
			employeeService.getEmployeeById(employee.getId());
		});
		
		Employee actual = employeeService.addNewEmployee(employee);
		
		Assertions.assertNotNull(employeeService.getEmployeeById(employee.getId()));
		
		Assertions.assertNotNull(actual);
		Assertions.assertEquals(employee.getId(), actual.getId());
	}
}

//public Employee addNewEmployee(Employee employee) throws EmployeeWithIDAlreadyPresentException {
//	
//	Optional<Employee> empOptional =  empRepo.findById(employee.getId());
//	
//	if (empOptional.isEmpty()) {
//		
//		empRepo.save(employee);
//		return employee;
//	}
//	
//	throw new EmployeeWithIDAlreadyPresentException();
//}






