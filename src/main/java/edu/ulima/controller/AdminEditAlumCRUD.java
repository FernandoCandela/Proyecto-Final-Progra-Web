
package edu.ulima.controller;

import edu.ulima.entidad.Country;
import edu.ulima.entidad.Gender;
import edu.ulima.entidad.Teacher;
import edu.ulima.entidad.Career;
import edu.ulima.entidad.TeacherType;
import edu.ulima.entidad.Student;
import edu.ulima.formulario.TeacherFormulario;
import edu.ulima.persistencia.CountriesRepositorio;
import edu.ulima.persistencia.GenderRepositorio;
import edu.ulima.persistencia.StudentRepositorio;
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
@RequestMapping("/editarAlumno")
public class AdminEditAlumCRUD {
    
    @Autowired
    private StudentRepositorio stdRep;
    @Autowired
    private GenderRepositorio genRep;

    @Autowired
    private CountriesRepositorio contRep;

    @Autowired
    private TeacherTypeRepositorio teaTyRep;
    
    String id = "";
    @RequestMapping(value = "/{y}",method = RequestMethod.GET)
    public String getIndex(Model model, @PathVariable("y") String y){
        id = y;
        
        List<TeacherType> tiposDocente = teaTyRep.findAll();
        model.addAttribute("tiposDocente", tiposDocente);
        
        Student Estudiante = stdRep.findByCodeOrId(Integer.parseInt(id), null);
        Integer codigo = Estudiante.getCode();
        model.addAttribute("codigo", codigo);
              
        Gender genero = Estudiante.getGender_id();
        model.addAttribute("genero", genero.getName());
        System.out.println(genero);
        
        Country pais = Estudiante.getCountry_id();
        model.addAttribute("pais", pais.getName());
        System.out.println(pais);
        
        Career career = Estudiante.getCareer_id();
        model.addAttribute("carrera", career.getName());
   
        
        return "adminEditAlumCRUD";
    }
    
    @RequestMapping(value = "/seleccionar/", method = RequestMethod.POST)
    public String actualizarDatos(Model model, @RequestParam("names") String names, 
            @RequestParam("last_names") String last_names, @RequestParam("email") String email,
                    @RequestParam("personal_email") String personal_email, @RequestParam("tw_user") String tw_user, 
                    @RequestParam("tw_pass") String tw_pass, @RequestParam("ad_user") String ad_user,  @RequestParam("url") String url){
        Student Estudiante = stdRep.findByCodeOrId(Integer.parseInt(id), null);
        Estudiante.setNames(names);
        Estudiante.setLast_names(last_names);
        Estudiante.setEmail(email);
        Estudiante.setPersonal_email(personal_email);
        Estudiante.setTw_user(tw_user);
        Estudiante.setTw_pass(tw_pass);
        Estudiante.setAd_user(ad_user);
        Estudiante.setPhoto_url(url);
        stdRep.save(Estudiante);
        return "redirect:/admin/gestionAlum/";
    }
}
