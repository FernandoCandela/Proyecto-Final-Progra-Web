package edu.ulima.persistencia;
import edu.ulima.entidad.Period;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeriodRepositorio extends JpaRepository<Period,String> {
    public Period findByName(String name);

}
