package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.apache.log4j.Logger;


@Controller
@RequestMapping(value = "/error")
public class ExceptionController extends AbstractController{
    private static Logger log = Logger.getLogger(ExceptionController.class);

    @RequestMapping(value = "code400", method = RequestMethod.GET)
    public String error400(){

     return "";
    }

}
