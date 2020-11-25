/*package edu.ulima.controller;

import edu.ulima.persistencia.StudentRepositorio;
import edu.ulima.persistencia.UserStudentRepositorio;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import edu.ulima.formulario.*;
import edu.ulima.entidad.*;

@Controller
@RequestMapping("/")
public class MainController {
    
    private UserStudentRepositorio uRep;
    @Autowired
    public void userController(UserStudentRepositorio uRep){
        this.uRep = uRep;
    }
    
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("StudentFormulario", new StudentFormulario());
        //holi
        return "loginAlumno";
    }
    
 @RequestMapping(value = "/",method = RequestMethod.POST)
    public String ingresar(@ModelAttribute StudentFormulario stdF,HttpServletRequest req){
        
        UserStudent userStd = uRep.findByUserAndPass(stdF.getCampo1(), stdF.getCampo2());
        if(userStd!=null){
            System.out.print("*se logea*");
            req.getSession().setAttribute("nombre", userStd.getUser());
            req.getSession().setAttribute("apellido", userStd.getPass()));
            req.getSession().setAttribute("usuario", user.getUsuario());
            return "redirect:/";
        }
        System.out.print("*Usuario o contraseña incorrecta*");
        return "redirect:/";
    }
    
   
    
    
    
    
    
    
  
    // GET: Show Login Page
   
    @RequestMapping(value = {"/loginStudent"}, method = RequestMethod.GET)
    public String loginAlumno(Model model) {
        return "loginAlumno";
    }
    
   
    
    @RequestMapping(value = "/loginAlumno",method = RequestMethod.POST)
    public String redRegistro(){
        return "redirect:/home/";
    }
    

    // GET: Show Login Page
    @RequestMapping(value = {"/loginTeacher"}, method = RequestMethod.GET)
    public String login2(Model model) {
        return "loginProfe";
    }

}
*/