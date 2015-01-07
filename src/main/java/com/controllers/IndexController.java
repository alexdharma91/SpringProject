package com.controllers;

import com.service.PersistentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Locale;
import java.util.ResourceBundle;

@Controller
@RequestMapping(value = "/")
public class IndexController {

    @Resource
    PersistentService persistentService;

    @RequestMapping(value = "employees",  method =  RequestMethod.GET)
    public String getMovie1(ModelMap model) {
        model.addAttribute("active" , 0);
        model.addAttribute("title", "Employees");
        return "index";
    }

    @RequestMapping(value = "payment-fond", method =  RequestMethod.GET)
    public String paymentFond(ModelMap model){
      model.addAttribute("active" ,1);
      model.addAttribute("title", "Payment Fond");
      return "payment_fond";
    }

    @RequestMapping(value = "order-absence")
    public String orderAbsence(ModelMap model){
        model.addAttribute("active" ,2);
        model.addAttribute("title", "Order Absence");
        return "order_absence";
    }

    @RequestMapping(value = "login", method =  RequestMethod.GET)
    public String loginGet(ModelMap model) {
        model.addAttribute("title", "Spring MVC");

        return "login";
    }

    @RequestMapping(value = "login", method =  RequestMethod.POST)
    public String loginPost(@RequestParam(value = "login", required = true) String login
             , @RequestParam(value = "password", required = true) String password){


        Locale locale = new Locale("RU", "RF");
        ResourceBundle labels = ResourceBundle.getBundle("messages.messages", locale);
        String mes = labels.getString("mes");

        int j = 0;
      return "login";
    }

}