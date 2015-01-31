package com.controllers;

import com.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController extends AbstractController{

    @RequestMapping(value = "show",  method =  RequestMethod.GET)
    public String show(ModelMap model) {
        List<Employee> employees =  persistentService.getAll(Employee.class);
        model.addAttribute("employees", employees);
        model.addAttribute("active" , 0);
        model.addAttribute("title", "Employees");
        return "employee";
    }

    @RequestMapping(value = "create",  method =  RequestMethod.GET)
    public String createGet(ModelMap model) {
        model.addAttribute("entity", "сотрудника");
        model.addAttribute("status", "creation");
        model.addAttribute("title", "Create employee");
        model.addAttribute("createText", "Создать сотрудника");
        return "createEmploee";
    }

    @ModelAttribute("employee")
    public Employee populate(){
        Employee employee = new Employee();
        employee.setName("name");
        employee.setSurName("SurName");
        return employee;
    }

    @RequestMapping(value = "create",  method =  RequestMethod.POST)
    public String createPost(ModelMap model, @ModelAttribute(value = "employee") Employee employee) {
        persistentService.save(employee);
        return "redirect:/employee/show";
    }

}
