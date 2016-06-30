package com.benjie.spring.demo.dao;

import java.util.List;

import com.benjie.spring.demo.model.Employee;

public interface EmployeeDao {

	Employee findById(int id);

	void savedEmployee(Employee employee);

	void deleteEmployeeBySsn(String ssn);

	List<Employee> findAllEmployees();

	Employee findEmployeeBySsn(String ssn);

}
