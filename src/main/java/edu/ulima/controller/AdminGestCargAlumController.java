package edu.ulima.controller;

import edu.ulima.clienterest.*;
import edu.ulima.entidad.*;
import edu.ulima.persistencia.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin/gestionAlum")
public class AdminGestCargAlumController {

    private StudentRepositorio stdRep;

    @Autowired
    public void userController(StudentRepositorio stdRep) {
        this.stdRep = stdRep;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String teacherInicio(Model model, HttpServletRequest req) {
        List<Student> students = stdRep.findAll();
        List<Student1> st1 = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            System.out.println("2********************************************");
            Student st = students.get(i);
            System.out.println(st);
            Gender ge = st.getGender_id();
            Career ca = st.getCareer_id();
            System.out.println(ge);
            Student1 s1 = new Student1();
            System.out.println(s1);
            s1.setCode(st.getCode());
            s1.setNames(st.getNames());
            s1.setLast_names(st.getLast_names());
            s1.setCarrer_name(ca.getName());
            s1.setGarden_name(ge.getName());
            st1.add(s1);

            model.addAttribute("listAlum", st1);

            System.out.println(s1);
        }
        System.out.println("********************************************");

        //return st1;
        return "adminGestCargAlum";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String buscarNombre(Model model, HttpServletRequest req, @RequestParam("nomAlumno") String nomAlumno, @RequestParam("codAlumno") Integer codAlumno) {
        //List<Student> students = stdRep.findByNamesContainingIgnoreCase(nomAlumno);
        if (nomAlumno == "") {
            List<Student> students = stdRep.findByCode(codAlumno);
            List<Student1> st1 = new ArrayList<>();
            for (int i = 0; i < students.size(); i++) {
                System.out.println("3********************************************");
                Student st = students.get(i);
                System.out.println(st);
                Gender ge = st.getGender_id();
                Career ca = st.getCareer_id();
                System.out.println(ge);
                Student1 s1 = new Student1();
                System.out.println(s1);
                s1.setCode(st.getCode());
                s1.setNames(st.getNames());
                s1.setLast_names(st.getLast_names());
                s1.setCarrer_name(ca.getName());
                s1.setGarden_name(ge.getName());
                st1.add(s1);

                model.addAttribute("listAlum", st1);

                System.out.println(s1);
            }
        }
        if (codAlumno == null) {
            List<Student> students = stdRep.findByNamesContainingIgnoreCase(nomAlumno);
            List<Student1> st1 = new ArrayList<>();
            for (int i = 0; i < students.size(); i++) {
                System.out.println("3********************************************");
                Student st = students.get(i);
                System.out.println(st);
                Gender ge = st.getGender_id();
                Career ca = st.getCareer_id();
                System.out.println(ge);
                Student1 s1 = new Student1();
                System.out.println(s1);
                s1.setCode(st.getCode());
                s1.setNames(st.getNames());
                s1.setLast_names(st.getLast_names());
                s1.setCarrer_name(ca.getName());
                s1.setGarden_name(ge.getName());
                st1.add(s1);

                model.addAttribute("listAlum", st1);

                System.out.println(s1);
            }
        }
        List<Student> students = stdRep.findByCodeAndNamesContainingIgnoreCase(codAlumno, nomAlumno);
        List<Student1> st1 = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            System.out.println("3********************************************");
            Student st = students.get(i);
            System.out.println(st);
            Gender ge = st.getGender_id();
            Career ca = st.getCareer_id();
            System.out.println(ge);
            Student1 s1 = new Student1();
            System.out.println(s1);
            s1.setCode(st.getCode());
            s1.setNames(st.getNames());
            s1.setLast_names(st.getLast_names());
            s1.setCarrer_name(ca.getName());
            s1.setGarden_name(ge.getName());
            st1.add(s1);
            
            model.addAttribute("listAlum", st1);

            System.out.println(s1);
        }
        System.out.println("********************************************");

        //return st1;
        return "adminGestCargAlum";
    }
}
