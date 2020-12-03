
package edu.ulima.controller;

import edu.ulima.persistencia.*;
import edu.ulima.entidad.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/agregarProfesor")
  
public class GestProfeCRUDController {
    
    private TeacherRepositorio teaRep;
    @Autowired
    public void claseController(TeacherRepositorio teaRep){
        this.teaRep = teaRep;
    }
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String teachInicio(Model model, HttpServletRequest req) {
        
            return "adminGestProfeCRUD";
        }
    
    //AQUI COMIENZA LO QUE ESTABA HACIENDO
    /*@RequestMapping(value = "/",method = RequestMethod.POST)
    public String crearProfe(@RequestParam("codProfe") Integer codProfe, 
            @RequestParam("nomProfe") String nomProfe, @RequestParam("generoProfe") String generoProfe){
        
        List<Teacher> Profe = teaRep.findAll();
        ArrayList numId = new ArrayList();
        for (int i = 0; i < Profe.size(); i++) {
            Teacher teacher = Profe.get(i);
            numId.add(teacher.getId());
        }
        System.out.println("********************");
        System.out.println(numId);
        Teacher teacher =  new Teacher();
        String idUltimo = numId.get(numId.size()-1).toString();
        System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOO");
        Integer id_ultimo= Integer.parseInt(idUltimo);
        teacher.setId(id_ultimo+1);
        teacher.setCode(codProfe);
        teacher.setNames(nomProfe);
        if(generoProfe.equals("1")){
            Gender ge = teacher.getGender_id();
            
        }
        
        
        
        teaRep.saveAndFlush(teacher);
        return "redirect:/inicioAdmin/";
    }*/
    
}
