package com.jrp.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jrp.pma.dto.EmployeeProject;
import com.jrp.pma.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {
	@Override
	public List<Employee> findAll();
	
	@Query(nativeQuery=true , value="SELECT e.firstname as firstname ,e.lastname as lastname ,count(pe.employee_id) as projectcount"
			+ " FROM employee e left join project_employee pe ON pe.employee_id=e.employee_id"
			+ " GROUP BY e.firstname ,e.lastname ORDER BY 3 DESC")
	public List<EmployeeProject> employeeprojects();
}
