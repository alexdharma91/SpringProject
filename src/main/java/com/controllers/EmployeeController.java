package com.controllers;

import com.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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

}
