package edu.ulima.controller;

import edu.ulima.entidad.*;
import edu.ulima.persistencia.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class ApiController {

    @Autowired
    private TeacherRepositorio teaRep;

    @Autowired
    private GenderRepositorio genRep;

    @Autowired
    private CountriesRepositorio counRep;

    @Autowired
    private TeacherTypeRepositorio teatyRep;

    @Autowired
    private StudentRepositorio stuRep;

    @Autowired
    private CareerRepositorio carrRep;


    @PostMapping("/leerArchivo")
    public String leerArchivoProf(@RequestBody String csv) {
        System.out.println(csv);
        String[] splitData = csv.split("\n");
        List<Teacher> profesores = teaRep.findAll();
        Integer id = profesores.get(profesores.size() - 1).getIde();
        for (String linea : splitData) {
            id++;
            System.out.println(linea);
            String[] profe = linea.split(",");

            Gender ge = genRep.findByIde(Integer.parseInt(profe[5]));
            Country coun = counRep.findById(Integer.parseInt(profe[6]));
            TeacherType teaTy = teatyRep.findById(Integer.parseInt(profe[7]));
            Teacher tea = new Teacher(id, Integer.parseInt(profe[0]), profe[1], profe[2], profe[3], profe[4], ge, coun, teaTy, profe[8]);
            System.out.println(tea);
            teaRep.saveAndFlush(tea);
        }
        return "CARGA DE PROFESORES OK";
    }

    @PostMapping("/leerArchivoAlumn")
    public String leerArchivoAlum(@RequestBody String csv) {
        System.out.println(csv);
        String[] splitData = csv.split("\n");
        List<Student> alumnos = stuRep.findAll();
        Integer id = alumnos.get(alumnos.size() - 1).getId();
        for (String linea : splitData) {
            id++;
            System.out.println(linea);
            String[] alumno = linea.split(",");

            Gender ge = genRep.findByIde(Integer.parseInt(alumno[8]));
            Career carr = carrRep.findByIde(Integer.parseInt(alumno[9]));
            Country coun = counRep.findById(Integer.parseInt(alumno[10]));

            Student std = new Student(id, Integer.parseInt(alumno[0]), alumno[1], alumno[2], alumno[3], alumno[4], alumno[5], alumno[6], alumno[7], ge, carr, coun, alumno[11]);
            System.out.println(std);
            stuRep.saveAndFlush(std);
        }
        return "CARGA DE ALUMNOS OK";
    }

}
