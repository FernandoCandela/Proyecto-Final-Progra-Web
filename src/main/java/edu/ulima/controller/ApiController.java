package edu.ulima.controller;

import edu.ulima.clienterest.Student1;
import edu.ulima.clienterest.Teacher1;
import edu.ulima.entidad.Student;
import edu.ulima.entidad.Gender;
import edu.ulima.entidad.Career;
import edu.ulima.entidad.Teacher;
import edu.ulima.entidad.TeacherType;
import edu.ulima.persistencia.StudentRepositorio;
import edu.ulima.persistencia.TeacherRepositorio;
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
    
    @Autowired
    private TeacherRepositorio teachRepo;

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

    @GetMapping("/listarProfe")
    public List<Teacher1> listarProfes() {
        System.out.println("********************************************");
        List<Teacher> teachers = teachRepo.findAll();    
        List<Teacher1> te1 = new ArrayList<>();
        for (int i = 0; i < teachers.size(); i++) {
            System.out.println("2********************************************");
            Teacher st = teachers.get(i);
            System.out.println(st);
            TeacherType ty = st.getTeacher_type_id();
            Gender ge = st.getGender_id();
            System.out.println(ge);
            Teacher1 s1 = new Teacher1();
            System.out.println(s1);
            s1.setCode(st.getCode());
            s1.setNames(st.getNames());
            s1.setLast_names(st.getLast_names());
            s1.setTeacher_type(ty.getName());
            s1.setGender_name(ge.getName());
            te1.add(s1);

            System.out.println(s1);
        }
        System.out.println("********************************************");

        return te1;
    }
    
    @GetMapping("/listasProf")
    public List<Teacher> listasProf(){
        List<Teacher> lp = teachRepo.findAll();
        return lp;
    }
}
