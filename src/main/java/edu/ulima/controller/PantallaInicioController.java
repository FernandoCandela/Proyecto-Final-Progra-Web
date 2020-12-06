
package edu.ulima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/inicio")
public class PantallaInicioController {
     @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        
        return "pantallaInicio";
    }
}
