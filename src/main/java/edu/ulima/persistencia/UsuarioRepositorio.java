package edu.ulima.persistencia;
import edu.ulima.entidad.UserStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<UserStudent,String> {
    public UserStudent findByUser(String usr);

}
