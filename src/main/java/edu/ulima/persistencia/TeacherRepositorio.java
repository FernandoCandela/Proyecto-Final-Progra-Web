package edu.ulima.persistencia;
import edu.ulima.entidad.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepositorio extends JpaRepository<Teacher,Integer> {
    public Teacher findByCode(Integer code);

}
