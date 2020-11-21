package edu.ulima.persistencia;
import edu.ulima.entidad.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepositorio extends JpaRepository<Course,String> {
    public Course findByName(String name);

}
