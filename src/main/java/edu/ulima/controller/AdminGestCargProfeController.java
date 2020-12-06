package edu.ulima.controller;

import edu.ulima.clienterest.*;
import edu.ulima.entidad.*;
import edu.ulima.persistencia.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

public class AdminGestCargProfeController {

    @Autowired
    private TeacherRepositorio teaRep;

    @RequestMapping({"/admin/gestionProfe"})
    public String teachInicio(Model model,
            @RequestParam(value = "page", defaultValue = "1") int page) {

        // -------------- Inicio algoritmos de paginacion
        final int maxResult = 6; // Cantidad de resultados por pagina
        final int maxNavigationPage = 10; // cantidad maxima de paginas

        final int pageIndex = page - 1 < 0 ? 0 : page - 1;

        // Cuantos resultados existen en total
        int totalRecords = teaRep.findAll().size();

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
        Page<Teacher> result0 = teaRep.findAll(pagina);

        // Convertir la lista de Entidad a Modelo
        List<Teacher1> ltmp = new ArrayList<>();

        for (Teacher t : result0) {

            Teacher1 t1 = new Teacher1(t.getCode(), t.getNames(), t.getLast_names(), " ", " ");
            Gender ide_ge = t.getGender_id();
            System.out.println("#################################################");
            System.out.println(ide_ge.getName());
            System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
            t1.setGender_name(ide_ge.getName());

            TeacherType ide_ty = t.getTeacher_type_id();
            t1.setTeacher_type(ide_ty.getName());

            ltmp.add(t1);
            System.out.println("******************************************************************");
            System.out.println(ltmp);
        }

        // Generar una pagina
        Page<Teacher1> result = new PageImpl(ltmp);

        // POner todo en el modelo
        model.addAttribute("paginationTeach", result);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("navigationPages", navigationPages);

        return "adminGestCargProfe";
    }

    @RequestMapping(value = "/admin/gestionProfe/", method = RequestMethod.POST)
    public String buscarNombre(Model model, HttpServletRequest req, @RequestParam("nomProfe") String nomProfe, @RequestParam("codProfe") Integer codProfe) {
        if (nomProfe == "") {
            List<Teacher> teachers = teaRep.findByCodeAndNamesContainingIgnoreCase(codProfe, nomProfe);
            List<Teacher1> tea1 = new ArrayList<>();
            for (Teacher t : teachers) {

                Teacher1 t1 = new Teacher1(t.getCode(), t.getNames(), t.getLast_names(), " ", " ");
                Gender ide_ge = t.getGender_id();
                System.out.println("#################################################");
                System.out.println(ide_ge.getName());
                System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
                t1.setGender_name(ide_ge.getName());

                TeacherType ide_ty = t.getTeacher_type_id();
                t1.setTeacher_type(ide_ty.getName());

                tea1.add(t1);
                model.addAttribute("paginationTeach", tea1);
                System.out.println("******************************************************************");
                System.out.println(tea1);

            }
        }
        if (codProfe == null) {
            List<Teacher> teachers = teaRep.findByNamesContainingIgnoreCase(nomProfe);
            List<Teacher1> tea1 = new ArrayList<>();

            for (Teacher t : teachers) {

                Teacher1 t1 = new Teacher1(t.getCode(), t.getNames(), t.getLast_names(), " ", " ");
                Gender ide_ge = t.getGender_id();
                System.out.println("#################################################");
                System.out.println(ide_ge.getName());
                System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
                t1.setGender_name(ide_ge.getName());

                TeacherType ide_ty = t.getTeacher_type_id();
                t1.setTeacher_type(ide_ty.getName());

                tea1.add(t1);
                model.addAttribute("paginationTeach", tea1);
                System.out.println("******************************************************************");
                System.out.println(tea1);
            }

        }
        List<Teacher> teachers = teaRep.findByCodeAndNamesContainingIgnoreCase(codProfe, nomProfe);
        List<Teacher1> tea1 = new ArrayList<>();
        for (Teacher t : teachers) {

            Teacher1 t1 = new Teacher1(t.getCode(), t.getNames(), t.getLast_names(), " ", " ");
            Gender ide_ge=t.getGender_id();
            System.out.println("#################################################");
            System.out.println(ide_ge.getName());
            System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
            t1.setGender_name(ide_ge.getName());
            
            TeacherType ide_ty = t.getTeacher_type_id();
            t1.setTeacher_type(ide_ty.getName());

            tea1.add(t1);
            model.addAttribute("paginationTeach", tea1);    
            System.out.println("******************************************************************");
            System.out.println(tea1);
            System.out.println("********************************************");

        
    }
        //return st1;
        return "adminGestCargProfe";
}

    @RequestMapping(value = "/admin/gestionProfe/ir", method = RequestMethod.POST)
    public String irAgegarProfe() {
        return "redirect:/agregarProfesor";
    }
    
    
    @RequestMapping(value = "/admin/gestionProfe/error", method = RequestMethod.POST)
    public String ir() {
        return "redirect:/admin/gestionProfe";
    }

    @RequestMapping(value = "/admin/gestionProfe/delete/{y}", method = RequestMethod.POST)
    public String borrar(@PathVariable("y") String y) {
        /*System.out.println("**************************");
        System.out.println(y);
        Integer y1 = Integer.parseInt(y);*/

        try {
            //interceptor.invoke(invocation);
            System.out.println("**************************");
            System.out.println(y);
            Integer y1 = Integer.parseInt(y);
            teaRep.deleteByCode(y1);
        } catch (DataIntegrityViolationException ex) {
            // expected
            System.out.println("NO PUEDE SER");
            return "error_borrar";
        }

        //teaRep.deleteByCode(y1);

        return "redirect:/admin/gestionProfe/";
    }
}
