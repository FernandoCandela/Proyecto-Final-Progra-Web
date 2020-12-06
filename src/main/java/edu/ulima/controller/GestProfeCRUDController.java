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

@Controller
@RequestMapping("/agregarProfesor")

public class GestProfeCRUDController {

    @Autowired
    private TeacherRepositorio teaRep;
    @Autowired
    private GenderRepositorio genRep;

    @Autowired
    private CountriesRepositorio contRep;

    @Autowired
    private TeacherTypeRepositorio teaTyRep;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String teachInicio(Model model, HttpServletRequest req) {

        List<Gender> generos = genRep.findAll();
        model.addAttribute("generos", generos);

        List<Country> paises = contRep.findAll();
        model.addAttribute("paises", paises);

        List<TeacherType> tiposDocente = teaTyRep.findAll();
        model.addAttribute("tiposDocente", tiposDocente);

        return "adminGestProfeCRUD";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String crearProfe(TeacherFormulario teacherForm) {
        System.out.println("*************CREACION DE PROFESOR*************");
        System.out.println(teacherForm);
        List<Teacher> profesores = teaRep.findAll();
        Integer id = profesores.get(profesores.size() - 1).getIde();
        Teacher teacher = new Teacher();
        teacher.setIde(id + 1);
        teacher.setCode(Integer.parseInt(teacherForm.getCode()));
        teacher.setNames(teacherForm.getNames());
        teacher.setLast_names(teacherForm.getLast_names());
        teacher.setEmail(teacherForm.getEmail());
        teacher.setPersonal_email(teacherForm.getPersonal_email());
        teacher.setGender_id(genRep.findByName(teacherForm.getGender_id()));
        teacher.setCountry_id(contRep.findByName(teacherForm.getCountry_id()));
        teacher.setTeacher_type_id(teaTyRep.findByName(teacherForm.getTeacher_type_id()));
        //teacher.setPhoto_url(teacherForm.getPhoto_url());
        teacher.setPhoto_url("UN-URL");
        teaRep.saveAndFlush(teacher);

        return "redirect:/admin/gestionProfe";

    }
   
}
