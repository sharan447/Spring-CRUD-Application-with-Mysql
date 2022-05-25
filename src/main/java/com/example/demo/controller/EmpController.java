package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmpService;

@Controller
public class EmpController {
	
	@Autowired
	private EmpService service;
	
	@GetMapping("/")
	public String home(Model m)
	{
		List<Employee> emp=service.getAllEmp();
		
		m.addAttribute("emp",emp);
		return "index";
		
	}
	
	@GetMapping("/addemp")
	public String addEmpForm()
	{
		return "add_emp";
	}
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e,HttpSession session)
	{
		System.out.println(e);
		service.addEmp(e);
		session.setAttribute("msg","Employee added successfully...");
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id,Model m)
	{
		
		Employee e=service.getEmpById(id);
		m.addAttribute("emp",e);
		return "edit";
	}
	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e,HttpSession session)
	{
		service.addEmp(e);
		session.setAttribute("msg", "Data update Sucessful.");
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id,HttpSession session)
	{
		service.delete(id);
		session.setAttribute("msg", "Employee deleted Sucessfully.");
		return "redirect:/";
	}
}
