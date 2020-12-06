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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("/admin/gestionAlum")

public class AdminGestCargAlumController {

    @Autowired
    private StudentRepositorio stdRep;
    private GenderRepositorio geRep;
    private CareerRepositorio caRep;

    @RequestMapping({"/admin/gestionAlum"})
    public String gestionAlum(Model model,
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
        // -------------- Fin algoritmos de paginacion

        /*
        Ir a la base de datos pero ..a buscar una pagina de datos
         */
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
        model.addAttribute("paginationAlumn", result);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("navigationPages", navigationPages);

        return "adminGestCargAlum";
    }

    @RequestMapping(value = "/admin/gestionAlum/", method = RequestMethod.POST)
    public String buscarNombre(Model model, HttpServletRequest req, @RequestParam("nomAlumno") String nomAlumno, @RequestParam("codAlumno") Integer codAlumno) {
        //List<Student> students = stdRep.findByNamesContainingIgnoreCase(nomAlumno);
        if (nomAlumno == "") {
            List<Student> students = stdRep.findByCode(codAlumno);
            List<Student1> st1 = new ArrayList<>();
            for (Student s : students) {

                Student1 s1 = new Student1(s.getCode(), s.getNames(), s.getLast_names(), " ", " ");
                Gender ide_ge = s.getGender_id();
                System.out.println("#################################################");
                System.out.println(ide_ge.getName());
                System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
                s1.setGarden_name(ide_ge.getName());

                Career ide_ca = s.getCareer_id();
                s1.setCarrer_name(ide_ca.getName());

                st1.add(s1);
                System.out.println("******************************************************************");
                System.out.println(st1);
                model.addAttribute("paginationAlumn", st1);
            }
        }
        if (codAlumno == null) {
            List<Student> students = stdRep.findByNamesContainingIgnoreCase(nomAlumno);
            List<Student1> st1 = new ArrayList<>();
            for (Student s : students) {

                Student1 s1 = new Student1(s.getCode(), s.getNames(), s.getLast_names(), " ", " ");
                Gender ide_ge = s.getGender_id();
                System.out.println("#################################################");
                System.out.println(ide_ge.getName());
                System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
                s1.setGarden_name(ide_ge.getName());

                Career ide_ca = s.getCareer_id();
                s1.setCarrer_name(ide_ca.getName());

                st1.add(s1);
                System.out.println("******************************************************************");
                System.out.println(st1);
                model.addAttribute("paginationAlumn", st1);
            }
        }
        List<Student> students = stdRep.findByCodeAndNamesContainingIgnoreCase(codAlumno, nomAlumno);
        List<Student1> st1 = new ArrayList<>();
        for (Student s : students) {

                Student1 s1 = new Student1(s.getCode(), s.getNames(), s.getLast_names(), " ", " ");
                Gender ide_ge = s.getGender_id();
                System.out.println("#################################################");
                System.out.println(ide_ge.getName());
                System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
                s1.setGarden_name(ide_ge.getName());

                Career ide_ca = s.getCareer_id();
                s1.setCarrer_name(ide_ca.getName());

                st1.add(s1);
                System.out.println("******************************************************************");
                System.out.println(st1);
                model.addAttribute("paginationAlumn", st1);
            }
        System.out.println("********************************************");

        //return st1;
        return "adminGestCargAlum";
    }
    
    @RequestMapping(value = "/admin/gestionAlum/ir", method = RequestMethod.POST)
    public String irAgegarProfe() {
        return "redirect:/agregarAlumno";
    }
    
    @RequestMapping(value = "/admin/gestionAlum/delete/{y}", method = RequestMethod.POST)
    public String borrar(@PathVariable("y") String y) {
        System.out.println("**************************");
        System.out.println(y);
        Integer y1 = Integer.parseInt(y);
        stdRep.deleteByCode(y1);
        return "redirect:/admin/gestionProfe/";
    }

}
