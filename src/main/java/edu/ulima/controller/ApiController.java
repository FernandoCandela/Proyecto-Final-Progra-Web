package edu.ulima.controller;

import edu.ulima.clienterest.Student1;
import edu.ulima.entidad.Student;
import edu.ulima.entidad.Gender;
import edu.ulima.entidad.Career;
import edu.ulima.persistencia.StudentRepositorio;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private StudentRepositorio studRepo;

    @GetMapping("/listarAlumno")
    public List<Student1> listarAlumnos() {
        System.out.println("********************************************");
        List<Student> students = studRepo.findAll();
        List<Student1> st1 = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            System.out.println("2********************************************");
            Student st = students.get(i);
            System.out.println(st);
            Gender ge = st.getGender_id();
            Career ca = st.getCareer_id();
            System.out.println(ge);
            Student1 s1 = new Student1();
            System.out.println(s1);
            s1.setCode(st.getCode());
            s1.setNames(st.getNames());
            s1.setLast_names(st.getLast_names());
            s1.setCarrer_name(ca.getName());
            s1.setGarden_name(ge.getName());
            st1.add(s1);

            System.out.println(s1);
        }
        System.out.println("********************************************");

        return st1;
    }

}
