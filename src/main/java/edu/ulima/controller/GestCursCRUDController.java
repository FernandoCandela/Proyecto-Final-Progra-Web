package edu.ulima.controller;

import edu.ulima.formulario.*;
import edu.ulima.persistencia.*;
import edu.ulima.entidad.*;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/agregarCurso")

public class GestCursCRUDController {

    @Autowired
    private CareerRepositorio carrRep;

    @Autowired
    private CourseRepositorio courRep;
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String teachInicio(Model model, HttpServletRequest req) {

        List<Career> carreras = carrRep.findAll();
        model.addAttribute("carreras", carreras);

        return "adminGestCursCRUD";
    }
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String crearProfe( @RequestParam("code") String code,@RequestParam("name") String name,@RequestParam("career") String career  ) {
        System.out.println("*************CREACION DE CURSO*************");
        System.out.println("Code: "+ code +" Name"+ name.toUpperCase() +" Career "+ career );
        List<Course> cursos = courRep.findAll();
        Integer id = cursos.get(cursos.size() - 1).getId();
        Course curso = new Course(id+1, Integer.parseInt(code), name.toUpperCase(), carrRep.findByName(career));
        courRep.saveAndFlush(curso);
        return "redirect:/admin/gestionCurso";

    }
}
