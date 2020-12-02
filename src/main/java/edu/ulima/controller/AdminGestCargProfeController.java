package edu.ulima.controller;

import edu.ulima.clienterest.*;
import edu.ulima.entidad.*;
import edu.ulima.persistencia.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin/gestionProfe")
public class AdminGestCargProfeController {

    private TeacherRepositorio teaRep;

    @Autowired
    public void userController(TeacherRepositorio teaRep) {
        this.teaRep = teaRep;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String teachInicio(Model model, HttpServletRequest req) {
        List<Teacher> teachers = teaRep.findAll();
        List<Teacher1> tea1 = new ArrayList<>();
        for (int i = 0; i < teachers.size(); i++) {
            System.out.println("2********************************************");
            Teacher t = teachers.get(i);
            System.out.println(t);
            Gender ge = t.getGender_id();
            TeacherType tt = t.getTeacher_type_id();
            System.out.println(ge);
            Teacher1 t1 = new Teacher1();
            System.out.println(t1);
            t1.setCode(t.getCode());
            t1.setNames(t.getNames());
            t1.setLast_names(t.getLast_names());
            t1.setGender_name(ge.getName());
            t1.setTeacher_type(tt.getName());
            tea1.add(t1);

            model.addAttribute("listProfe", tea1);

            System.out.println(t1);
        }
        System.out.println("********************************************");

        //return st1;
        return "adminGestCargProfe";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String buscarNombre(Model model, HttpServletRequest req, @RequestParam("nomProfe") String nomProfe, @RequestParam("codProfe") Integer codProfe) {
        //List<Student> students = stdRep.findByNamesContainingIgnoreCase(nomAlumno);
        if (nomProfe == "") {
            List<Teacher> teachers = teaRep.findByCodeAndNamesContainingIgnoreCase(codProfe, nomProfe);
            List<Teacher1> tea1 = new ArrayList<>();
            for (int i = 0; i < teachers.size(); i++) {
                System.out.println("2********************************************");
                Teacher t = teachers.get(i);
                System.out.println(t);
                Gender ge = t.getGender_id();
                TeacherType tt = t.getTeacher_type_id();
                System.out.println(ge);
                Teacher1 t1 = new Teacher1();
                System.out.println(t1);
                t1.setCode(t.getCode());
                t1.setNames(t.getNames());
                t1.setLast_names(t.getLast_names());
                t1.setGender_name(ge.getName());
                t1.setTeacher_type(tt.getName());
                tea1.add(t1);

                model.addAttribute("listProfe", tea1);

                System.out.println(t1);

            }
        }
        if (codProfe == null) {
            List<Teacher> teachers = teaRep.findByNamesContainingIgnoreCase(nomProfe);
            List<Teacher1> tea1 = new ArrayList<>();
            for (int i = 0; i < teachers.size(); i++) {
                System.out.println("2********************************************");
                Teacher t = teachers.get(i);
                System.out.println(t);
                Gender ge = t.getGender_id();
                TeacherType tt = t.getTeacher_type_id();
                System.out.println(ge);
                Teacher1 t1 = new Teacher1();
                System.out.println(t1);
                t1.setCode(t.getCode());
                t1.setNames(t.getNames());
                t1.setLast_names(t.getLast_names());
                t1.setGender_name(ge.getName());
                t1.setTeacher_type(tt.getName());
                tea1.add(t1);

                model.addAttribute("listProfe", tea1);

                System.out.println(t1);
            }
        }
        List<Teacher> teachers = teaRep.findByCodeAndNamesContainingIgnoreCase(codProfe, nomProfe);
        List<Teacher1> tea1 = new ArrayList<>();
        for (int i = 0; i < teachers.size(); i++) {
            System.out.println("2********************************************");
            Teacher t = teachers.get(i);
            System.out.println(t);
            Gender ge = t.getGender_id();
            TeacherType tt = t.getTeacher_type_id();
            System.out.println(ge);
            Teacher1 t1 = new Teacher1();
            System.out.println(t1);
            t1.setCode(t.getCode());
            t1.setNames(t.getNames());
            t1.setLast_names(t.getLast_names());
            t1.setGender_name(ge.getName());
            t1.setTeacher_type(tt.getName());
            tea1.add(t1);

            model.addAttribute("listProfe", tea1);

            System.out.println(t1);
        }
        System.out.println("********************************************");

        //return st1;
        return "adminGestCargProfe";
    }
    
    @RequestMapping(value = "/ir", method = RequestMethod.POST)
    public String irAgegarProfe() {
        return "redirect:/agregarProfesor";
    }
}
