
package edu.ulima.controller;

import edu.ulima.entidad.Country;
import edu.ulima.entidad.Gender;
import edu.ulima.entidad.Course;
import edu.ulima.entidad.Career;
import edu.ulima.entidad.TeacherType;
import edu.ulima.entidad.Student;
import edu.ulima.formulario.TeacherFormulario;
import edu.ulima.persistencia.CareerRepositorio;
import edu.ulima.persistencia.CountriesRepositorio;
import edu.ulima.persistencia.GenderRepositorio;
import edu.ulima.persistencia.StudentRepositorio;
import edu.ulima.persistencia.TeacherRepositorio;
import edu.ulima.persistencia.CourseRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/editarCurso")
public class AdminEditCursoCRUD {
    
    @Autowired
    private CourseRepositorio couRep;
    
    @Autowired
    private CareerRepositorio carrRep;
    
    
    String id = "";
    @RequestMapping(value = "/{y}",method = RequestMethod.GET)
    public String getIndex(Model model, @PathVariable("y") String y){
        id = y;
        
        List<Career> carreras = carrRep.findAll();
        model.addAttribute("carreras", carreras);
        
        Course Curso = couRep.findByCode(Integer.parseInt(id));
        Integer codigo = Curso.getCode();
        model.addAttribute("codigo", codigo);
       
        return "adminEditCursCRUD";
    }
    
    @RequestMapping(value = "/seleccionar/", method = RequestMethod.POST)
    public String actualizarDatos(Model model, @RequestParam("name") String name, @RequestParam("career") String career){
        Course Curso = couRep.findByCode(Integer.parseInt(id));
        Curso.setName(name);
        Curso.setCareer_id(carrRep.findByName(career));
        couRep.save(Curso);
        return "redirect:/admin/gestionCurso/";
    }
}
