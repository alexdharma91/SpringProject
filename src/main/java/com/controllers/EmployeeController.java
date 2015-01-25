package com.controllers;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.model.Employee;
import com.model.State;
import com.service.Reflector;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

@Controller
@RequestMapping(value = "/employee")
@SessionAttributes("fields, test")
public class EmployeeController extends AbstractController {

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
        List<Reflector.ClassField> fields = reflector.getFields(Employee.class);

        model.addAttribute("entity", "сотрудника");
        model.addAttribute("status", "creation");
        model.addAttribute("title", "Create employee");
        model.addAttribute("createText", "Создать сотрудника");

        model.addAttribute("test", "test");
        model.addAttribute("fields", fields);
        return "create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String createPost(@ModelAttribute("fields") ArrayList<Reflector.ClassField> fields,
                             @ModelAttribute("test") String test, SessionStatus status) {

         Map map  = Maps.newHashMap();

         for(Reflector.ClassField field : fields){
             map.put(field.getName(), field.getValue());
         }

        Employee employee = new Employee();

        try {
            BeanUtils.populate(employee, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InvocationTargetException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        persistentService.save(employee);

        //  model.addAttribute("fields", fields);
        return "create";
    }

}
