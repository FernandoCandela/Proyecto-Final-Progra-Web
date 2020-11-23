package edu.ulima.persistencia;
import edu.ulima.entidad.SectionStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionStudentRepositorio extends JpaRepository<SectionStudent,Integer> {
   // public SectionStudent findById(Integer id);

}
