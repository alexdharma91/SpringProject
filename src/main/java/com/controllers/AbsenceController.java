package com.controllers;

import com.model.Absence;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/absence")
public class AbsenceController extends AbstractController{

    @RequestMapping(value = "show")
    public String show(ModelMap model){
        List<Absence> absences = persistentService.getAll(Absence.class);
        model.addAttribute("absences" , absences);
        model.addAttribute("active" , 2);
        model.addAttribute("title", "Order Absence");
        return "order_absence";
    }

}
