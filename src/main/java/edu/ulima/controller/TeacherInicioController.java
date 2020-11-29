
package edu.ulima.controller;

import edu.ulima.formulario.StudentFormulario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/inicioProfe")
public class TeacherInicioController {
    @RequestMapping(value = "",method = RequestMethod.GET)
    public String studentInicio(Model model) {
        return "inicioProfe";
    }
}
