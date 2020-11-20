/*package edu.ulima;

import edu.ulima.entidad.*;
import edu.ulima.persistencia.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DummyLoad implements CommandLineRunner {

    @Autowired
    private UsuarioRepositorio repo;
    
    @Autowired
    private PasswordEncoder pwEncoder;
    
    @Override
    public void run(String... args) throws Exception {
        // Aqui se ejecuta la logica principal
        // INSERT - save
        // DELETE - remove
        // UPDATE  - merge
        // SELECT find - select
        User first = new User(1);
        Gender g = new Gender(1, "femenino");
        Career career = new Career(1, "math");
        Country country = new Country(1, "Peru");
        Student firstS = new Student(1, 1, "prueba", "prueba", "p", "p", "p", "p", "p", "p", g, career.getId(), country);
        //repo.save( new UserStudent("20171871", true, pwEncoder.encode("1234"), "estudiante" ) );
        repo.save(new UserStudent(1, first, firstS.getId(), "20171871", pwEncoder.encode("password"), "1234", "1234"));
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
}
*/
