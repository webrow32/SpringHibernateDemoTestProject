package com.benjie.spring.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.benjie.spring.demo.dao.EmployeeDao;
import com.benjie.spring.demo.model.Employee;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao dao;

	@Override
	public Employee findById(int id) {
		return dao.findById(id);
	}

	@Override
	public void saveEmployee(Employee employee) {
		dao.savedEmployee(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		Employee entity = dao.findById(employee.getId());
		if (entity != null) {
			entity.setName(employee.getName());
			entity.setJoiningDate(employee.getJoiningDate());
			entity.setSalary(employee.getSalary());
			entity.setSsn(employee.getSsn());
		}
	}

	@Override
	public void deleteEmployeeBySsn(String ssn) {
		dao.deleteEmployeeBySsn(ssn);
	}

	@Override
	public List<Employee> findAllEmployees() {
		return dao.findAllEmployees();
	}

	@Override
	public Employee findEmployeeBySsn(String ssn) {
		return dao.findEmployeeBySsn(ssn);
	}

	@Override
	public boolean isEmployeeSsnUnique(Integer id, String ssn) {
		Employee employee = findEmployeeBySsn(ssn);
		return (employee == null || ((id != null) && (employee.getId()==id)));
	}

}
