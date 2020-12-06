package edu.ulima.persistencia;
import edu.ulima.entidad.SectionTeacher;
import edu.ulima.entidad.Section;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SectionTeacherRepositorio extends JpaRepository<SectionTeacher,Integer> {
    public SectionTeacher findByIde(Integer ide);
    
    //@Query("SELECT t FROM TSECTIONTEACHER WHERE t.SECTION_ID = ?1")
    //public List<SectionTeacher> findBySection_id(Section section_id);

}
