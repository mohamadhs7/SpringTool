package com.jrp.pma.ProjectController;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.entities.Employee;
import com.jrp.pma.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	ProjectRepository pro;
	@Autowired
	EmployeeRepository emo;
	
	@GetMapping
	public String ShowAll(Model m ) {
		List<Project> projects = pro.findAll();
		m.addAttribute("projects",projects);
		return "Project/list-project";
	}
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		model.addAttribute("project", new Project());
		List<Employee> employees =  emo.findAll();
		model.addAttribute("allEmployee",employees);
		return "Project/new-project";
	}
	@PostMapping("/save")
	public String CreateProject(Model m , Project p ) { //@RequestParam List<Long> employees\\) {
		pro.save(p);
//		Iterable<Employee> choosenEmployee =emo.findAllById(employees);
//		for(Employee e:choosenEmployee){
//			e.setProjects(p);
//			emo.save(e);
//		}
		return"redirect:/projects/new";
	}
}