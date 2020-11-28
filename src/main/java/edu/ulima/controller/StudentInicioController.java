package edu.ulima.controller;

import edu.ulima.formulario.StudentFormulario;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/inicioAlum")
public class StudentInicioController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String studentInicio(Model model, HttpServletRequest req) {
        return "inicioAlumno";
    }
}