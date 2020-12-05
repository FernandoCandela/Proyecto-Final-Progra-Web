package edu.ulima.controller;

import edu.ulima.entidad.Student;
import edu.ulima.formulario.StudentFormulario;
import edu.ulima.persistencia.StudentRepositorio;
import static java.lang.Integer.parseInt;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/inicioAlum")
public class StudentInicioController {

    @Autowired
    private StudentRepositorio sRep;
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String studentInicio(Model model, HttpServletRequest req) {
        String usuario = String.valueOf(req.getSession().getAttribute("user"));
        List<Student> students = sRep.findByCode(parseInt(usuario));
        
        for(int i=0; i<students.size(); i++){
            Student st = students.get(i); 
            String nombres = st.getNames() + " " + st.getLast_names();
            model.addAttribute("nombres", nombres);
            System.out.println("Nombre es "+nombres);
        }
        return "inicioAlumno";
    }
}
