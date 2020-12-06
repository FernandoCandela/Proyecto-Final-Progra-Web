
package edu.ulima.controller;

import edu.ulima.entidad.Country;
import edu.ulima.entidad.Gender;
import edu.ulima.entidad.Teacher;
import edu.ulima.entidad.TeacherType;
import edu.ulima.formulario.TeacherFormulario;
import edu.ulima.persistencia.CountriesRepositorio;
import edu.ulima.persistencia.GenderRepositorio;
import edu.ulima.persistencia.TeacherRepositorio;
import edu.ulima.persistencia.TeacherTypeRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/editarProfe")
public class AdminEditProfeCRUD {
    
    @Autowired
    private TeacherRepositorio teaRep;
    @Autowired
    private GenderRepositorio genRep;

    @Autowired
    private CountriesRepositorio contRep;

    @Autowired
    private TeacherTypeRepositorio teaTyRep;
    
    String id = "";
    @RequestMapping(value = "/{y}",method = RequestMethod.GET)
    public String getIndex(Model model, TeacherFormulario teacherForm, @PathVariable("y") String y){
        id = y;
        
        List<TeacherType> tiposDocente = teaTyRep.findAll();
        model.addAttribute("tiposDocente", tiposDocente);
        
        Teacher Profe = teaRep.findByCodeOrIde(Integer.parseInt(id), null);
        Integer codigo = Profe.getCode();
        model.addAttribute("codigo", codigo);
        
        Gender genero = Profe.getGender_id();
        model.addAttribute("genero", genero.getName());
        System.out.println(genero);
        
        Country pais_nombre = Profe.getCountry_id();
        model.addAttribute("pais", pais_nombre.getName());
        System.out.println(pais_nombre);  
        
        TeacherType tipo = Profe.getTeacher_type_id();
        model.addAttribute("tipo", tipo.getName());
        System.out.println(tipo);
        
        return "adminEditProfeCRUD";
    }
    
    @RequestMapping(value = "/seleccionar/", method = RequestMethod.POST)
    public String actualizarDatos(Model model, @RequestParam("names") String names, 
            @RequestParam("last_names") String last_names, @RequestParam("email") String email,
                    @RequestParam("personal_email") String personal_email, @RequestParam("url") String url){
        Teacher Profe = teaRep.findByCodeOrIde(Integer.parseInt(id), null);
        Profe.setNames(names);
        Profe.setLast_names(last_names);
        Profe.setEmail(email);
        Profe.setPersonal_email(personal_email);
        Profe.setPhoto_url(url);
        teaRep.save(Profe);
        return "redirect:/admin/gestionProfe/";
    }
}
