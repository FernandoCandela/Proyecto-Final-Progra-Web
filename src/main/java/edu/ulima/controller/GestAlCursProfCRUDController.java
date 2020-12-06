package edu.ulima.controller;

import edu.ulima.clienterest.Student1;
import edu.ulima.persistencia.*;
import edu.ulima.entidad.*;
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
@RequestMapping("/agregarSeccion")

public class GestAlCursProfCRUDController {

    @Autowired
    private TeacherRepositorio teaRep;
    @Autowired
    private StudentRepositorio stdRep;
    private GenderRepositorio geRep;
    private CareerRepositorio caRep;
    @Autowired
    private CourseRepositorio courRep;

    @Autowired
    private SectionRepositorio secRep;

    @Autowired
    private SectionTeacherRepositorio secteaRep;
    @Autowired
    private PeriodRepositorio peRep;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String teachInicio(Model model, HttpServletRequest req, 
            @RequestParam(value = "page", defaultValue = "1") int page) {

        
         // -------------- Inicio algoritmos de paginacion
        final int maxResult = 6; // Cantidad de resultados por pagina
        final int maxNavigationPage = 10; // cantidad maxima de paginas

        final int pageIndex = page - 1 < 0 ? 0 : page - 1;

        // Cuantos resultados existen en total
        int totalRecords = stdRep.findAll().size();

        // calcular cuantas paginas se debe tener
        int totalPages = 0;
        if (totalRecords % maxResult == 0) {
            totalPages = totalRecords / maxResult;
        } else {
            totalPages = (totalRecords / maxResult) + 1;
        }

        int currentPage = pageIndex + 1;

        List<Integer> navigationPages = new ArrayList<>();
        int current = currentPage > totalPages ? totalPages : currentPage;

        int begin = current - maxNavigationPage / 2;
        int end = current + maxNavigationPage / 2;

        // La primera pagina
        navigationPages.add(1);
        if (begin > 2) {
            navigationPages.add(-1);
        }

        // Llenar un arreglo con los numero de paginas
        for (int i = begin; i < end; i++) {
            if (i > 1 && i < totalPages) {
                System.out.println("En navigationPages.add " + i);
                navigationPages.add(i);
            }
        }

        if (end < totalPages - 2) {
            navigationPages.add(-1);
        }

        navigationPages.add(totalPages);
        
        Pageable pagina = PageRequest.of(pageIndex, maxResult);
        System.out.println(pageIndex);
        System.out.println(maxResult);
        // Invocar al repositorio para que retorne la pagina indicada
        Page<Student> result0 = stdRep.findAll(pagina);

        // Convertir la lista de Entidad a Modelo
        List<Student1> ltmp = new ArrayList<>();
        
        for (Student s : result0) {

            Student1 s1 = new Student1(s.getCode(), s.getNames(), s.getLast_names(), " ", " ");
            Gender ide_ge = s.getGender_id();
            System.out.println("#################################################");
            System.out.println(ide_ge.getName());
            System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
            s1.setGarden_name(ide_ge.getName());

            Career ide_ca = s.getCareer_id();
            s1.setCarrer_name(ide_ca.getName());

            ltmp.add(s1);
            System.out.println("******************************************************************");
            System.out.println(ltmp);
        }

        // Generar una pagina
        Page<Student1> result = new PageImpl(ltmp);

        // POner todo en el modelo
        model.addAttribute("paginationSA", result);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("navigationPages", navigationPages);

      
        
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
        Integer id = sections.get(sections.size() - 1).getIde();

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
