package com.controllers;

import com.google.common.base.Optional;
import com.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController extends AbstractController {

    @ModelAttribute("employee")
    public Employee populate() {
        Employee employee = new Employee();
        employee.setName("name");
        employee.setSurName("SurName");
        return employee;
    }

    @RequestMapping(value = "show", method = RequestMethod.GET)
    public String show(ModelMap model) {
        List<Employee> employees = persistentService.getAll(Employee.class);
        model.addAttribute("employees", employees);
        model.addAttribute("active", 0);
        model.addAttribute("title", "Employees");
        return "employee";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createGet(ModelMap model) {
        model.addAttribute("entity", "сотрудника");
        model.addAttribute("status", "creation");
        model.addAttribute("title", "Create employee");
        model.addAttribute("createText", "Создать сотрудника");
        return "createEmploee";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String createPost(ModelMap model, HttpSession session, @ModelAttribute(value = "employee") Employee employee) {
       Long employeeId = Long.valueOf(Optional.fromNullable(session.getAttribute("employeeId")).or("-1").toString());

        if(!employeeId.equals(-1l)){
            employee.setId(employeeId);
        }

        persistentService.save(employee);
        return "redirect:/employee/show";
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String editGet(ModelMap model, HttpSession session, @RequestParam(value = "employeeId") Long employeeId) {
        session.setAttribute("employeeId", employeeId);
        Employee employee = persistentService.get(Employee.class, employeeId);
        model.addAttribute("employee", employee);
        model.addAttribute("title", "title");
        model.addAttribute("entity", "сотрудника");
        model.addAttribute("status", "creation");
        model.addAttribute("createText", "Отредактировать сотрудника");
        return "createEmploee";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String deleteGet(@RequestParam(value = "employeeId") Long employeeId){
        persistentService.delete(Employee.class, employeeId);
        return "redirect:/employee/show";
    }

}
