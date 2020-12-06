package edu.ulima.controller;

import edu.ulima.formulario.*;
import edu.ulima.persistencia.*;
import edu.ulima.entidad.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/agregarAlumno")

public class GestAlumCRUDController {

    @Autowired
    private StudentRepositorio stdRep;
    @Autowired
    private GenderRepositorio genRep;

    @Autowired
    private CountriesRepositorio contRep;

    @Autowired
    private TeacherTypeRepositorio teaTyRep;
    
    @Autowired
    private CareerRepositorio carRep;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String teachInicio(Model model, HttpServletRequest req) {

        List<Gender> generos = genRep.findAll();
        model.addAttribute("generos", generos);

        List<Country> paises = contRep.findAll();
        model.addAttribute("paises", paises);
        
        List<Career> carreras = carRep.findAll();
        model.addAttribute("carrera", carreras);

        return "adminGestAlumCRUD";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String crearProfe(StudentFormulario studentForm) {
        System.out.println("*************CREACION DE ALUMNO*************");
        System.out.println(studentForm);
        List<Student> alumnos = stdRep.findAll();
        Integer id = alumnos.get(alumnos.size() - 1).getId();
        Student student = new Student();
        student.setId(id + 1);
        student.setCode(Integer.parseInt(studentForm.getCode()));
        student.setNames(studentForm.getNames());
        student.setLast_names(studentForm.getLast_names());
        student.setEmail(studentForm.getEmail());
        student.setPersonal_email(studentForm.getPersonal_email());
        student.setGender_id(genRep.findByName(studentForm.getGender_id()));
        student.setCareer_id(carRep.findByName(studentForm.getCareer_id()));
        student.setCountry_id(contRep.findByName(studentForm.getCountry_id()));
        //teacher.setPhoto_url(teacherForm.getPhoto_url());
        student.setPhoto_url("UN-URL");
        stdRep.saveAndFlush(student);

        return "redirect:/admin/gestionAlum";

    }
   
}
