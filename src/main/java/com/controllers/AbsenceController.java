package com.controllers;

import com.model.Absence;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/absence")
public class AbsenceController extends AbstractController {

    @RequestMapping(value = "show")
    public String show(ModelMap model) {
        List<Absence> absences = persistentService.getAll(Absence.class);
        model.addAttribute("absences", absences);
        model.addAttribute("active", 2);
        model.addAttribute("title", "Order Absence");
        return "order_absence";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createGet(ModelMap model) {
        model.addAttribute("title", "absence create");
        model.addAttribute("status", "creation");
        model.addAttribute("createText", "Создать отсутствие");
        return "createAbsence";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String createPost() {

        return "redirect:/absence/show";
    }


    @ModelAttribute("absence")
    public Absence populate() {
        Absence absence = new Absence();
        return absence;
    }


}
