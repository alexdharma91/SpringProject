package com.controllers;

import com.google.common.base.Optional;
import com.model.Employee;
import com.model.Payout;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping(value = "/payout")
public class PayoutController extends AbstractController {

    private final String SQL_GET_INITIATOR_IDS = "SELECT id from EMPLOYEES";

    @ModelAttribute("payout")
    public Payout populate() {
        Payout payout = new Payout();
        payout.setAmount(BigDecimal.valueOf(100));
        payout.setInitiatorId(0l);
        payout.setType("TYPE");
        return payout;
    }

    @RequestMapping(value = "show", method = RequestMethod.GET)
    public String show(ModelMap model) {
        List<Payout> payouts = persistentService.getAll(Payout.class);
        model.addAttribute("active", 1);
        model.addAttribute("title", "Payment Fond");
        model.addAttribute("payouts", payouts);
        return "payment_fond";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createGet(ModelMap model) {
        List<Employee> initiators = persistentService.getAll(Employee.class);
        model.addAttribute("initiators", initiators);
        model.addAttribute("recievers", initiators);
        model.addAttribute("title", "Payment Fond");
        model.addAttribute("status", "creation");
        model.addAttribute("createText", "Создать отсутствие");
        return "createPayment";
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String editGet(ModelMap model, @RequestParam(value = "payoutId") Long payoutId, HttpSession session){
        session.setAttribute("payoutId", payoutId);
        Payout payout = persistentService.get(Payout.class, payoutId);
        model.addAttribute("payout", payout);
        return "createPayment";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String createPost(@ModelAttribute(value = "payout") Payout payout, HttpSession session) {
        Long payoutId = Long.valueOf(Optional.fromNullable(session.getAttribute("payoutId")).or("-1").toString());

        if(!payoutId.equals(-1l)){
            payout.setId(payoutId);
        }

        persistentService.save(payout);
        return "redirect:/payout/show";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String deleteGet(@RequestParam(value = "payoutId") Long payoutId){
        persistentService.delete(persistentService.get(Payout.class, payoutId));
        return "redirect:/payout/show";
    }

}
