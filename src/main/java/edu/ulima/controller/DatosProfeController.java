
package edu.ulima.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import edu.ulima.entidad.*;
import edu.ulima.persistencia.*;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("/datosProfe")
public class DatosProfeController {
    
    private TeacherRepositorio teacherRep;
    @Autowired
    public void userController(TeacherRepositorio teacherRep){
        this.teacherRep = teacherRep;
    }
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String studentInicio(Model model, HttpServletRequest req) {
        String user = String.valueOf(req.getSession().getAttribute("user"));
        model.addAttribute("user", user);
        
        Teacher Profe = teacherRep.findByCode(Integer.parseInt(user));
        System.out.println(Profe);
        System.out.println("******************");
        String nombre= Profe.getNames();
        model.addAttribute("nombre", nombre);
        return "profesor";
    }
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String actualizaCorreo(HttpServletRequest req, @RequestParam("correoProfe") String correo){
        System.out.println("************************");
        String user = String.valueOf(req.getSession().getAttribute("user"));
        System.out.println(user);
        Teacher Profe = teacherRep.findByCode(Integer.parseInt(user));
        System.out.println(Profe);
        Profe.setEmail(correo);
        System.out.println(Profe.getEmail());
        teacherRep.save(Profe);
        
        System.out.println("************************");
        return "inicioProfesor";
    }
}
