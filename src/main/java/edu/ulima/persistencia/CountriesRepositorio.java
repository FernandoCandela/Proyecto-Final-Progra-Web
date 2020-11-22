
package edu.ulima.persistencia;

import edu.ulima.entidad.Country;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CountriesRepositorio extends JpaRepository<Country,String> {
    public Country findByName(String name);
    
}
