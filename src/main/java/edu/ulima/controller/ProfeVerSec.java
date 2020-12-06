package edu.ulima.controller;

import edu.ulima.clienterest.Student1;
import edu.ulima.clienterest.VerSeccion1;
import edu.ulima.entidad.Career;
import edu.ulima.entidad.Gender;
import edu.ulima.entidad.Section;
import edu.ulima.entidad.Student;
import edu.ulima.persistencia.CareerRepositorio;
import edu.ulima.persistencia.GenderRepositorio;
import edu.ulima.persistencia.SectionRepositorio;
import edu.ulima.persistencia.StudentRepositorio;
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
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("/admin/gestionAlum")

public class ProfeVerSec {

    @Autowired
    private StudentRepositorio stdRep;

    @Autowired
    private GenderRepositorio geRep;

    @Autowired
    private CareerRepositorio caRep;

    @Autowired
    private SectionRepositorio secRep;

    @RequestMapping({"/seccionesProfe"})
    public String verSeccion(Model model,HttpServletRequest req,
            @RequestParam(value = "page", defaultValue = "1") int page) {

        String user = String.valueOf(req.getSession().getAttribute("user"));
        String teacher_id = String.valueOf(req.getSession().getAttribute("teacher_id"));

        List<Section> secciones = secRep.findAll();

        model.addAttribute("secciones", secciones);

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
        List<VerSeccion1> ltmp = new ArrayList<>();

        for (Student s : result0) {

            VerSeccion1 vs1 = new VerSeccion1(s.getCode(), s.getNames(), s.getLast_names(), s.getAd_user(), s.getTw_user(), s.getTw_pass());

            ltmp.add(vs1);
            System.out.println("******************************************************************");
            System.out.println(ltmp);
        }

        // Generar una pagina
        Page<VerSeccion1> result = new PageImpl(ltmp);

        // POner todo en el modelo
        model.addAttribute("paginationVerSec", result);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("navigationPages", navigationPages);

        return "profeVerSeccion";
    }

}
