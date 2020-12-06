package edu.ulima.persistencia;
import edu.ulima.entidad.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepositorio extends JpaRepository<Section,Integer> {
    
    public Section findByIde(Integer ide);
    
    public Section findByCode(Integer code);

}
