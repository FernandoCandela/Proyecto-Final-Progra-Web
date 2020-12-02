package edu.ulima.controller;
import edu.ulima.entidad.*;
import edu.ulima.persistencia.*;
import edu.ulima.clienterest.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
    
@Controller
@RequestMapping("/admin/gestionCurso")
public class AdminGestCargCursController {

    private CourseRepositorio courseRep;

    @Autowired
    public void userController(CourseRepositorio courseRep) {
        this.courseRep = courseRep;
    }

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
        return "adminGestCursos";
    }
}
