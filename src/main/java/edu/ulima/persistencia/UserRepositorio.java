package edu.ulima.persistencia;
import edu.ulima.entidad.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositorio extends JpaRepository<User,Integer> {
    public User findByIde(Integer ide);

}
