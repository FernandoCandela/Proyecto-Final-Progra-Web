package edu.ulima.controller;

import java.util.List;
import edu.ulima.entidad.*;
import edu.ulima.persistencia.SectionRepositorio;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

    @Autowired
    private SectionRepositorio secRep;

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
    public String seccionesProfe(Model model, HttpServletRequest req) {
        List<Section> secciones = secRep.findAll();

        model.addAttribute("secciones", secciones);

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
