package com.jrp.pma.ProjectController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jrp.pma.SimpleClasses.Car;
import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.dto.EmployeeProject;
import com.jrp.pma.entities.Project;

@Controller
@RequestMapping
public class HomeController {
	@Value("${version}")
	String var;
	
	@Autowired
	Car car;
	@Autowired
	ProjectRepository pro;
	@Autowired
	EmployeeRepository emo;
	@GetMapping
	public String DisplayProject( Model m) {
		m.addAttribute("version",var);
		
		List<Project> projects = pro.findAll();
		m.addAttribute("projects", projects);
		
		List<EmployeeProject> employeeProjects =emo.employeeprojects();
		m.addAttribute("employeeProjectsCnt", employeeProjects);
		return "Main/home";
	}
}
