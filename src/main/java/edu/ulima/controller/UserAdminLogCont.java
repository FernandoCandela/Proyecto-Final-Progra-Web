package edu.ulima.controller;

import edu.ulima.persistencia.UserStudentRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import edu.ulima.persistencia.StudentRepositorio;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class UserAdminLogCont {

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String home() {
        return "loginAdmin";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public String login(
            HttpServletRequest req,
            @RequestParam("user") String user,
            @RequestParam("password") String password) {

        System.out.println("Codigo: " + user);
        System.out.println("Nombre: " + password);
        if (user.equals("admin") && password.equals("admin")) {
            System.out.print("*se logea");
            req.getSession().setAttribute("user", user);
            req.getSession().setAttribute("password", password);
            return "redirect:/inicioAdmin";
        } else {
            System.out.print("*Usuario o contraseña incorrecta*");

            return "redirect:/";
        }

    }

}
