package com.controllers;

import com.model.Employee;
import com.service.Reflector;
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

    @RequestMapping(value = "create",  method =  RequestMethod.GET)
    public String createGet(ModelMap model) {
        List<Reflector.ClassField> fields = reflector.getFields(Employee.class);

        model.addAttribute("entity", "сотрудника");
        model.addAttribute("status", "creation");
        model.addAttribute("title", "Create employee");
        model.addAttribute("createText", "Создать сотрудника");
        model.addAttribute("fields", fields);
        return "create";
    }

    @RequestMapping(value = "create",  method =  RequestMethod.POST)
    public String createPost(ModelMap model) {
        List<Reflector.ClassField> fields = reflector.getFields(Employee.class);

        model.addAttribute("entity", "сотрудник");
        model.addAttribute("status", "created");
        model.addAttribute("title", "Create employee");
        model.addAttribute("createText", "Создать сотрудника");
        model.addAttribute("fields", fields);
        return "create";
    }




}
