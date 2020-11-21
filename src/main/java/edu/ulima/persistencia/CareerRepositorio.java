package edu.ulima.persistencia;
import edu.ulima.entidad.Career;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CareerRepositorio extends JpaRepository<Career,String> {
    public Career findByName(String name);

}
