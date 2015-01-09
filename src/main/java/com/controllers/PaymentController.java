package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/payment")
public class PaymentController extends AbstractController {

    @RequestMapping(value = "show", method =  RequestMethod.GET)
    public String show(ModelMap model){
        model.addAttribute("active" ,1);
        model.addAttribute("title", "Payment Fond");
        return "payment_fond";
    }

}
