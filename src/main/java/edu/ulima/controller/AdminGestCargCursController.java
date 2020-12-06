package edu.ulima.controller;

import edu.ulima.entidad.*;
import edu.ulima.persistencia.*;
import edu.ulima.clienterest.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
//@RequestMapping("/admin/gestionCurso")
public class AdminGestCargCursController {

    @Autowired
    private CourseRepositorio courseRep;

    @RequestMapping({"/admin/gestionCurso"})
    public String gestionCurso(Model model,
            @RequestParam(value = "page", defaultValue = "1") int page) {

        // -------------- Inicio algoritmos de paginacion
        final int maxResult = 2; // Cantidad de resultados por pagina
        final int maxNavigationPage = 10; // cantidad maxima de paginas

        final int pageIndex = page - 1 < 0 ? 0 : page - 1;

        // Cuantos resultados existen en total
        int totalRecords = courseRep.findAll().size();

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
        // Invocar al repositorio para que retorne la pagina indicada
        Page<Course> result0 = courseRep.findAll(pagina);

        // Convertir la lista de Entidad a Modelo
        List<Course1> ltmp = new ArrayList<>();

        for (Course c : result0) {

            Course1 c1 = new Course1(c.getCode(), c.getName(), " ");

            System.out.println("#################################################");
            Career ide_ca = c.getCareer_id();
            c1.setCarrer_name(ide_ca.getName());

            ltmp.add(c1);
            System.out.println("******************************************************************");
            System.out.println(ltmp);
        }

        // Generar una pagina
        Page<Course1> result = new PageImpl(ltmp);

        // POner todo en el modelo
        model.addAttribute("paginationCourses", result);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("navigationPages", navigationPages);

        return "adminGestCursos";
    }

    @RequestMapping(value = "/admin/gestionCurso/ir", method = RequestMethod.POST)
    public String irAgregarCurso() {
        return "redirect:/agregarCurso";
    }
    
    @RequestMapping(value = "/admin/gestionCurso/delete/{y}", method = RequestMethod.POST)
    public String borrar(@PathVariable("y") String y) {
        /*System.out.println("**************************");
        System.out.println(y);
        Integer y1 = Integer.parseInt(y);*/

        try {
            //interceptor.invoke(invocation);
            System.out.println("**************************");
            System.out.println(y);
            Integer y1 = Integer.parseInt(y);
            courseRep.deleteByCode(y1);
        } catch (DataIntegrityViolationException ex) {
            // expected
            System.out.println("NO PUEDE SER");
            return "error_borrar";
        }

        //teaRep.deleteByCode(y1);

        return "redirect:/admin/gestionCurso/";
    }
    
    @RequestMapping(value = "/admin/gestionCurso/seleccionar/{y}", method = RequestMethod.POST)
    public String seleccionarClase(@PathVariable("y") String y){
        
        System.out.println("**************************************************");
        System.out.println(y);
        Integer y1 = Integer.parseInt(y);
        System.out.println(y1);
        return "redirect:/editarCurso/" + y;
    }

    /*public void userController(CourseRepositorio courseRep) {
        this.courseRep = courseRep;
    }*/
 /*
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String courseInicio(Model model, HttpServletRequest req) {
        List<Course> cursos = courseRep.findAll();
        List<Course1> cr1 = new ArrayList<>();
        for (int i = 0; i < cursos.size(); i++) {
            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            Course cour = cursos.get(i);
            System.out.println(cour);
            Career ca = cour.getCareer_id();
            System.out.println(ca);
            
            
            Course1 c1 = new Course1();
            System.out.println(c1);
            c1.setCode(cour.getCode());
            c1.setName(cour.getName());
            c1.setCarrer_name(ca.getName());
            cr1.add(c1);

            model.addAttribute("listCour", cr1);

            System.out.println(c1);
        }
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        //return st1;
        return "adminGestCursos2";
    }
     */
}
