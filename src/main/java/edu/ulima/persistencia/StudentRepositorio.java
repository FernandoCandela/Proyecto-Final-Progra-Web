package edu.ulima.persistencia;

import edu.ulima.entidad.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepositorio extends JpaRepository<Student, Integer> {

    public Student findByCode(Integer code);

}
