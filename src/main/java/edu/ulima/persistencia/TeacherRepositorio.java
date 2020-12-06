package edu.ulima.persistencia;
import edu.ulima.entidad.Teacher;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface TeacherRepositorio extends JpaRepository<Teacher,Integer> {
    public Teacher findByCodeOrIde(Integer code, Integer ide);
    public List<Teacher> findByCode(Integer code);
    public List<Teacher> findByNamesContainingIgnoreCase(String names);
    public List<Teacher> findByCodeAndNamesContainingIgnoreCase(Integer code, String names);
    
    public Teacher findByIde(Integer ide);
    
    public Teacher findByNames(String names);
    
    @Transactional
    public int deleteByCode(Integer code);
}
