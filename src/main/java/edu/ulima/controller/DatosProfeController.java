
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
    private CountriesRepositorio countRepo;
    @Autowired
    public void userController(TeacherRepositorio teacherRep, CountriesRepositorio countRepo) {
        this.teacherRep = teacherRep;
        this.countRepo = countRepo;
    }
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String teacherInicio(Model model, HttpServletRequest req) {

        String user = String.valueOf(req.getSession().getAttribute("user"));

        model.addAttribute("user", user);
        Teacher Profe = teacherRep.findByCode(Integer.parseInt(user));
        System.out.println(Profe);
        
        System.out.println("******************");
        String nombre= Profe.getNames();
        model.addAttribute("nombre", nombre);
        
        String apellidos= Profe.getLast_names();
        model.addAttribute("apellidos", apellidos);
        
        String correo= Profe.getEmail();
        model.addAttribute("correo", correo);
        String correoPersonal= Profe.getPersonal_email();
        model.addAttribute("correoPersonal", correoPersonal);
        
        
        Integer ide = Profe.getId();
        model.addAttribute("ide", ide);
        //System.out.println(ide);
        
        Country pais_nombre = Profe.getCountry_id();
        model.addAttribute("pais_nombre",pais_nombre.getName());
        System.out.println(pais_nombre);
       
        TeacherType tipo=Profe.getTeacher_type_id();
        model.addAttribute("tipo",tipo.getName());
        System.out.println(tipo);
        
        Gender genero = Profe.getGender_id();
        model.addAttribute("genero",genero.getName());
        System.out.println(genero);
        
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
