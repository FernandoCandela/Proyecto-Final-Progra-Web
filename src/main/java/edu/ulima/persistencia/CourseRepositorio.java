package edu.ulima.persistencia;
import edu.ulima.entidad.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface CourseRepositorio extends JpaRepository<Course,String> {
    public Course findByName(String name);
    public Course findByCode(Integer code);
    
    @Transactional
    public int deleteByCode(Integer code);
}
