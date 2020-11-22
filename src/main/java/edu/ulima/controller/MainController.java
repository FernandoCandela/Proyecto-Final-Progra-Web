package edu.ulima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @RequestMapping(value = "/")
    public String home() {
        //holi
        return "loginAdmin";
    }

    // GET: Show Login Page
    @RequestMapping(value = {"/loginStudent"}, method = RequestMethod.GET)
    public String login1(Model model) {
        return "loginAlumno";
    }

    // GET: Show Login Page
    @RequestMapping(value = {"/loginTeacher"}, method = RequestMethod.GET)
    public String login2(Model model) {
        return "loginProfe";
    }

}
