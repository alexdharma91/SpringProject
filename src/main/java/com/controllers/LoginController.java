package com.controllers;

import com.model.Employee;
import com.service.SpringAuthenticationProvider;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/log")
public class LoginController extends AbstractController {

    @Resource
    SpringAuthenticationProvider authenticationProvider;

    @RequestMapping(method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "in", method = RequestMethod.GET)
    public String loginGet(ModelMap model){
        model.addAttribute("title", "wef");
        return "login";
    }

    @RequestMapping(value = "in", method = RequestMethod.POST)
    public String loginPost(ModelMap model, @RequestParam(value = "login", required = true) String login
                            ,@RequestParam(value = "password", required = true) String password){

        DetachedCriteria employeeCriteria = DetachedCriteria.forClass(Employee.class);
        employeeCriteria.add(Restrictions.eq("login", login));
        employeeCriteria.add(Restrictions.sqlRestriction("LIMIT 1"));

        Employee employee = (Employee) persistentService.get(employeeCriteria);




       // UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken();

        authenticationProvider.authenticate(null);


        return "redirect:/";
    }

    @RequestMapping(value = "out", method = RequestMethod.GET)
    public String logoutGet(){
        return "";
    }


}
