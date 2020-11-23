package edu.ulima.persistencia;
import edu.ulima.entidad.SectionTeacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionTeacherRepositorio extends JpaRepository<SectionTeacher,Integer> {
   // public SectionTeacher findById(Integer id);

}
