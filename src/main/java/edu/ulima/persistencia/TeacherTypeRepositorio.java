package edu.ulima.persistencia;

import edu.ulima.entidad.TeacherType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherTypeRepositorio extends JpaRepository<TeacherType, String> {

    public TeacherType findByName(String name);

}
