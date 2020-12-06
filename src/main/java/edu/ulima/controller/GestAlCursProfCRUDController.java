package edu.ulima.controller;

import edu.ulima.formulario.*;
import edu.ulima.persistencia.*;
import edu.ulima.entidad.*;
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
@RequestMapping("/agregarSeccion")

public class GestAlCursProfCRUDController {

    @Autowired
    private TeacherRepositorio teaRep;
    @Autowired
    private CourseRepositorio courRep;

    @Autowired
    private SectionRepositorio secRep;

    @Autowired
    private SectionTeacherRepositorio secteaRep;
    @Autowired
    private PeriodRepositorio peRep;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String teachInicio(Model model, HttpServletRequest req) {

        List<Course> cursos = courRep.findAll();
        model.addAttribute("cursos", cursos);

        List<Teacher> teachers = teaRep.findAll();
        List<Teacher> profes = new ArrayList<>();
        List<Teacher> jefePracticas = new ArrayList<>();
        for (Teacher tea : teachers) {
            TeacherType teaType = tea.getTeacher_type_id();
            if (teaType.getId() == 1) {
                profes.add(tea);
            } else {
                jefePracticas.add(tea);
            }
        }
        model.addAttribute("profes", profes);
        model.addAttribute("jefePracticas", jefePracticas);

        return "adminAlCursProfCRUD";
    }

    @RequestMapping(value = "/crearSeccion", method = RequestMethod.POST)
    public String crearSesion(@RequestParam("code") String code,
            @RequestParam("course") String course,
            @RequestParam("profe") String profe,
            @RequestParam("jefePractica") String jefePractica) {

        List<Period> periodos = peRep.findAll();
        Period pe = periodos.get(periodos.size() - 1);

        List<Section> sections = secRep.findAll();
        Integer id = sections.get(sections.size() - 1).getId();

        Course curso = courRep.findByName(course);

        Section sec = new Section(id + 1, Integer.parseInt(code), curso, pe);
        secRep.saveAndFlush(sec);

        List<SectionTeacher> secTea = secteaRep.findAll();
        Integer id2 = secTea.get(secTea.size() - 1).getIde();

        Teacher prof = teaRep.findByNames(profe);
        SectionTeacher sectea1 = new SectionTeacher(id2, sec, prof);
        System.out.println(sectea1);
        secteaRep.saveAndFlush(sectea1);
        System.out.println(prof);
        System.out.println("*****************************************");
        Teacher jp = teaRep.findByNames(jefePractica);
        if (jp != null) {
          
            SectionTeacher sectea2 = new SectionTeacher(id2 + 1, sec, jp);
            System.out.println(sectea2);
            secteaRep.saveAndFlush(sectea2);
        }
        return "redirect:/agregarSeccion";

    }

}
