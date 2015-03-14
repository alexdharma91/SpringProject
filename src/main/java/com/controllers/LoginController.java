package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/log")
public class LoginController extends AbstractController {

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
    public String loginPost(ModelMap model, @RequestParam(value = "login", required = true) Long login
                            ,@RequestParam(value = "password", required = true) Long password){

        return "index";
    }

    @RequestMapping(value = "out", method = RequestMethod.GET)
    public String logoutGet(){
        return "";
    }


}
