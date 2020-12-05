
package edu.ulima.controller;

import edu.ulima.persistencia.StudentRepositorio;
import edu.ulima.persistencia.TeacherRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
    @Autowired
    private StudentRepositorio sRep;
    
    @Autowired
    private TeacherRepositorio tRep;
    /*@RequestMapping(value = "/admin/gestionAlum")
    public String adminGestionAl() {
        return "adminGestCargAlum";
    }*/
    /*
    @RequestMapping(value = "/datosAlum")
    public String datosAlum() {
        return "datosAlumno";
    }*/
    
    @RequestMapping(value = "/inicioAdmin")
    public String inicioAdmin() {
        return "inicioAdmin";
    }
    
    @RequestMapping(value = "/seccionesProfe")
    public String seccionesProfe() {
        return "profeVerSeccion";
    }
    
    /*@RequestMapping(value = "/admin/gestionProfe")
    public String adminGestionProf() {
        return "adminGestCargProfe";
    }*/
    /*
    @RequestMapping(value = "/admin/gestionCurso")
    public String adminGestionCurso() {
        return "adminGestCursos";
    }
    */
    /*
    @RequestMapping(value = "/admin/gestionSeccion")
    public String adminGestionSeccion() {
        return "adminGestSecc";
    }*/
}
