package com.controllers;

import com.google.common.base.Optional;
import com.model.Absence;
import com.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/absence")
public class AbsenceController extends AbstractController {

    private static final Logger logger = Logger.getLogger(AbsenceController.class);

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

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String editGet(ModelMap model, HttpSession session, @RequestParam(value = "absenceId") Long absenceId) {
        model.addAttribute("title", "absence create");
        model.addAttribute("status", "creation");
        model.addAttribute("createText", "Создать отсутствие");
        session.setAttribute("absenceId", absenceId);
        Absence absence = persistentService.get(Absence.class, absenceId);
        model.addAttribute("absence", absence);
        return "createAbsence";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String createPost(@ModelAttribute(value = "absence") Absence absence, HttpSession session) {
        Long absenceId = Long.valueOf(Optional.fromNullable(session.getAttribute("absenceId")).or("-1").toString());

        if(!absenceId.equals(-1l)){
            absence.setId(absenceId);
        }

        persistentService.save(absence);
        return "redirect:/absence/show";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String deleteGet(@RequestParam(value = "absenceId") Long absenceId){
        persistentService.delete(Absence.class, absenceId);
        return "redirect:/absence/show";
    }

    @ModelAttribute("absence")
    public Absence populate() {
        Absence absence = new Absence();
        absence.setType("тип");
        absence.setStartDate(new Date());
        absence.setEndDate(new Date());
        return absence;
    }

}
