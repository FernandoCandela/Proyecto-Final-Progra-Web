package edu.ulima.persistencia;

import edu.ulima.entidad.Student;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepositorio extends JpaRepository<Student, Integer> {
    public Student findByCodeOrId(Integer code, Integer id);
    public List<Student> findByCode(Integer code);
    public List<Student> findByNamesContainingIgnoreCase(String names);
    public List<Student> findByCodeAndNamesContainingIgnoreCase(Integer code, String names);
}
