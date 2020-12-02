package edu.ulima.persistencia;
import edu.ulima.entidad.Teacher;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepositorio extends JpaRepository<Teacher,Integer> {
    public Teacher findByCode(Integer code);
    public List<Teacher> findByNamesContainingIgnoreCase(String names);
    public List<Teacher> findByCodeAndNamesContainingIgnoreCase(Integer code, String names);

}
