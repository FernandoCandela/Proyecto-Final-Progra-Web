
package edu.ulima.controller;

import edu.ulima.persistencia.UserStudentRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import edu.ulima.entidad.*;
import edu.ulima.persistencia.UserTeacherRepositorio;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/login")
public class UserTeacherLogCont {
    private UserTeacherRepositorio teacherRep;
    @Autowired
    public void userController(UserTeacherRepositorio teacherRep){
        this.teacherRep = teacherRep;
    }
    
    @RequestMapping(value = "/teacher",method = RequestMethod.GET)
    public String home(Model model) {
        //model.addAttribute("StudentFormulario", new StudentFormulario());
        return "loginProfe";
    }
    
    
    @RequestMapping(value = "/teacher",method = RequestMethod.POST)
    public String ingresar(
            HttpServletRequest req,
            @RequestParam("user") String user,
            @RequestParam("password") String password
    ){
        System.out.println("1++++++++++++++++++++++++++++++++++++");
        System.out.println(user);
        System.out.println(password);
        System.out.println("2++++++++++++++++++++++++++++++++++++");
        
        UserTeacher userTeaRep = teacherRep.findByUserAndPass(user, password);
        System.out.println(userTeaRep);
        System.out.println("3++++++++++++++++++++++++++++++++");
        if(userTeaRep!=null){
            System.out.print("*se logea*");
            req.getSession().setAttribute("user", user);
            req.getSession().setAttribute("password", password);
            return "redirect:/inicioProfe";
        }else{
            System.out.print("*Usuario o contraseña incorrecta*");
            return "loginProfe";
        }
        
    }
    
    
    
}
