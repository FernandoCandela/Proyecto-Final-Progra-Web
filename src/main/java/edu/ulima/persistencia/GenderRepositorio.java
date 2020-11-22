package edu.ulima.persistencia;
import edu.ulima.entidad.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepositorio extends JpaRepository<Gender,String> {
    public Gender findByName(String name);

}
