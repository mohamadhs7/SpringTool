package com.jrp.pma.ProjectController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.entities.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository emr;
	
	@GetMapping
	public String ShowAll(Model m ,Employee e) {
		List<Employee> employees = emr.findAll();
		m.addAttribute("employees",employees);
		return "Employee/list-employee";
	}


	@GetMapping("/new")
	public String CreateEmplooyes(Model m) {
		m.addAttribute("employee", new Employee());
		return "Employee/new-employee";
	}
	
	@PostMapping("/save")
	public String SendEmplooyes(Model m , Employee e) {
		emr.save(e);
		return "redirect:/employees/new";
	}
	
	
	
}
