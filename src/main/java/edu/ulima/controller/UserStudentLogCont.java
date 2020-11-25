
package edu.ulima.controller;

import edu.ulima.persistencia.UserStudentRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import edu.ulima.formulario.*;
import org.springframework.web.bind.annotation.ModelAttribute;
import edu.ulima.entidad.*;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/login")
public class UserStudentLogCont {
    private UserStudentRepositorio uRep;
    @Autowired
    public void userController(UserStudentRepositorio uRep){
        this.uRep = uRep;
    }
    
    @RequestMapping(value = "/student",method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("StudentFormulario", new StudentFormulario());
        //holi
        return "loginAlumno";
    }
    /*
    @RequestMapping( value="/consultar", method=RequestMethod.POST)
    public String consultar( @RequestParam("user") String userStd,@RequestParam("pass") String passStd ) {
        UserStudent userStdRep = uRep.findByUserAndPass(userStd, passStd);
        
        if ( userStdRep == null ) {
            System.out.println("no hay");
            return "redirect:/";
        }
        
        return "redirect:/home/";
        

    }
    */
    
    
    @RequestMapping(value = "/student",method = RequestMethod.POST)
    public String ingresar(
            HttpServletRequest req,
            @RequestParam("user") String user,
            @RequestParam("password") String password
    ){
        System.out.println("1++++++++++++++++++++++++++++++++++++");
        System.out.println(user);
        System.out.println(password);
        System.out.println("2++++++++++++++++++++++++++++++++++++");
        
        UserStudent userStdRep = uRep.findByUserAndPass(user, password);
        System.out.println(userStdRep);
        System.out.println("3++++++++++++++++++++++++++++++++");
        if(userStdRep!=null){
            System.out.print("*se logea*");
            req.getSession().setAttribute("user", user);
            req.getSession().setAttribute("password", password);
            return "redirect:/home";
        }

        System.out.print("*Usuario o contraseña incorrecta*");
        return "loginAlumno";
    }
    
    
    
}
