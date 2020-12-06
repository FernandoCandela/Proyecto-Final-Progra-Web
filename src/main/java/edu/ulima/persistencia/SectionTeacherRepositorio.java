package edu.ulima.persistencia;
import edu.ulima.entidad.SectionTeacher;
import edu.ulima.entidad.*;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SectionTeacherRepositorio extends JpaRepository<SectionTeacher,Integer> {
    public SectionTeacher findByIde(Integer ide);
    
    //public List<SectionTeacher> findByTeacher_id(Teacher teacher_id);
    //@Query("SELECT t FROM TSECTIONTEACHER WHERE t.SECTION_ID = ?1")
    //public SectionTeacher findBySection_id(Section section_id);

}
