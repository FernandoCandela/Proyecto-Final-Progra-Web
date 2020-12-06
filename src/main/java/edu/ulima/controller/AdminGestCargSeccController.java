package edu.ulima.controller;

import edu.ulima.entidad.*;
import edu.ulima.persistencia.*;
import edu.ulima.clienterest.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("/admin/gestionSeccion")
public class AdminGestCargSeccController {

    @Autowired
    private SectionRepositorio sectionRep;

    @Autowired
    private SectionTeacherRepositorio sctRep;

    @Autowired
    private TeacherRepositorio teaRep;

    @RequestMapping({"/admin/gestionSeccion"})
    public String sectionInicio(Model model,
            @RequestParam(value = "page", defaultValue = "1") int page) {

        // -------------- Inicio algoritmos de paginacion
        final int maxResult = 6; // Cantidad de resultados por pagina
        final int maxNavigationPage = 10; // cantidad maxima de paginas

        final int pageIndex = page - 1 < 0 ? 0 : page - 1;

        // Cuantos resultados existen en total
        int totalRecords = sectionRep.findAll().size();

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
        Page<Section> result0 = sectionRep.findAll(pagina);

        // Convertir la lista de Entidad a Modelo
        List<Section1> ltmp = new ArrayList<>();

        for (Section sc : result0) {

            Section1 sc1 = new Section1();
            sc1.setCode(sc.getCode());
            Course ide_co = sc.getCourse_id();
            sc1.setCourse_name(ide_co.getName());
            sc1.setCourse_code(ide_co.getCode());

            Career ide_ca = ide_co.getCareer_id();
            sc1.setCarrer_name(ide_ca.getName());

            Period ide_pe = sc.getPeriod_id();
            sc1.setPeriod_name(ide_pe.getName());
            Integer id_seccion = sc.getIde();
            System.out.println(id_seccion);

            System.out.println("************************aki******************************************");

            ltmp.add(sc1);
            System.out.println(sc1);
            System.out.println("******************************************************************");
            System.out.println(ltmp);
 
        }

        // Generar una pagina
        Page<Section1> result = new PageImpl(ltmp);

        // POner todo en el modelo
        model.addAttribute("paginationSecc", result);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("navigationPages", navigationPages);

        return "adminGestSecc";
    }

    @RequestMapping(value = "/admin/gestionSec/ir", method = RequestMethod.POST)
    public String irAgegarSec() {
        return "redirect:/agregarSeccion";
    }

}
