
package edu.ulima.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/agregarProfesor")
  
public class GestProfeCRUDController {
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String teachInicio(Model model, HttpServletRequest req) {
        
            return "adminGestProfeCRUD";
        }

    
}
