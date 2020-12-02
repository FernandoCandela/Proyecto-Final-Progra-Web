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
@RequestMapping("/admin/gestionSeccion")
public class AdminGestCargSeccController {

    private SectionRepositorio sectionRep;

    @Autowired
    public void userController(SectionRepositorio sectionRep) {
        this.sectionRep = sectionRep;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String sectionInicio(Model model, HttpServletRequest req) {
        List<Section> secciones = sectionRep.findAll();
        List<Section1> sect1 = new ArrayList<>();
        for (int i = 0; i < secciones.size(); i++) {
            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            Section sect = secciones.get(i);
            System.out.println(sect);
            
            Course co= sect.getCourse_id();
            //Career ca = sect.getCareer_id();
            Period pe= sect.getPeriod_id();
            //falta el de teacher 
            
            
            Section1 sec1 = new Section1();
            System.out.println(sec1);
            sec1.setCode(sect.getCode());
            sec1.setCourse_name(co.getName());
            sec1.setCourse_code(co.getCode());
            //sec1.setCarrer_name(ca.getName());
            sec1.setPeriod_name(co.getName());
            //teacher
            sect1.add(sec1);

            model.addAttribute("listSecc", sect1);

            System.out.println(sec1);
        }
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        //return st1;
        return "adminGestSecc";
    }
}
