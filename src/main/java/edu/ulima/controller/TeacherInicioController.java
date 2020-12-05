
package edu.ulima.controller;

import edu.ulima.formulario.StudentFormulario;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import edu.ulima.entidad.*;
import edu.ulima.persistencia.*;
import static java.lang.Integer.parseInt;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("/inicioProfe")
public class TeacherInicioController {
    @Autowired
    private TeacherRepositorio tRep;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String teacherInicio(Model model, HttpServletRequest req) {
        String usuario = String.valueOf(req.getSession().getAttribute("user"));
        List<Teacher> teachers = tRep.findByCode(parseInt(usuario));
        
        for(int i=0; i<teachers.size(); i++){
            Teacher te = teachers.get(i); 
            String nombresT = te.getNames() + " " + te.getLast_names();
            model.addAttribute("nombresT", nombresT);
            System.out.println("Nombre es "+nombresT);
        }
        return "inicioProfesor";
    }
    
    /*@RequestMapping(value = "/", method = RequestMethod.POST)
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
        return "profesor";
    }*/
}
