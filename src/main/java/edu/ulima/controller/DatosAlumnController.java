package edu.ulima.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import edu.ulima.entidad.*;
import edu.ulima.persistencia.*;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("/datosAlum")
public class DatosAlumnController {

    private StudentRepositorio studentRep;

    @Autowired
    public void userController(StudentRepositorio studentRep) {
        this.studentRep = studentRep;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String studentInicio(Model model, HttpServletRequest req) {

        String user = String.valueOf(req.getSession().getAttribute("user"));
        String student_id = String.valueOf(req.getSession().getAttribute("student_id"));

        model.addAttribute("user", user);
        Student Estudiante = studentRep.findByCodeOrId(Integer.parseInt(user), null);
        System.out.println(Estudiante);

        System.out.println("******************");
        String nombre = Estudiante.getNames();
        model.addAttribute("nombre", nombre);

        String apellidos = Estudiante.getLast_names();
        model.addAttribute("apellidos", apellidos);

        /**
         * *******Para el nombre en el header*********
         */
        String nombreCompleto = nombre + " " + apellidos;
        model.addAttribute("nombres", nombreCompleto);
        /**
         * ******************************************
         */

        String correo = Estudiante.getEmail();
        model.addAttribute("correo", correo);
        String correoPersonal = Estudiante.getPersonal_email();
        model.addAttribute("correoPersonal", correoPersonal);

        Gender genero = Estudiante.getGender_id();
        model.addAttribute("genero", genero.getName());
        System.out.println(genero);

        Country pais_nombre = Estudiante.getCountry_id();
        model.addAttribute("pais_nombre", pais_nombre.getName());
        System.out.println(pais_nombre);

        Career carrera = Estudiante.getCareer_id();
        model.addAttribute("carrera", carrera.getName());

        Integer ide = Estudiante.getId();
        model.addAttribute("ide", ide);
        String url = Estudiante.getPhoto_url();
        model.addAttribute("url", url);
        System.out.println("8888888888888888888888888888888888888888888888888888");
        System.out.println(url);
        return "datosAlumno";
    }

    /*@RequestMapping(value = "/", method = RequestMethod.POST)
    public String actualizaCorreo(HttpServletRequest req, @RequestParam("correoProfe") String correo){
        System.out.println("************************");
        String user = String.valueOf(req.getSession().getAttribute("user"));
        String teacher_id = String.valueOf(req.getSession().getAttribute("teacher_id"));
        System.out.println(user);
        Teacher Profe = teacherRep.findByCodeOrId(Integer.parseInt(user), null);
        System.out.println(Profe);
        Profe.setEmail(correo);
        System.out.println(Profe.getEmail());
        teacherRep.save(Profe);
        
        System.out.println("************************");
        return "inicioProfesor";
    }
     */
}
