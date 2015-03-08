package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;
import java.util.ResourceBundle;

@Controller
@RequestMapping(value = "/")
public class IndexController extends AbstractController{

    @RequestMapping(method = RequestMethod.GET)
    public String aaa(ModelMap model) {
        return "redirect:/index";
    }

    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String bbb(ModelMap model){
        model.addAttribute("title", "Spring MVC");
        return "index";
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