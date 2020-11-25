package edu.ulima.persistencia;
import edu.ulima.entidad.UserStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserStudentRepositorio extends JpaRepository<UserStudent,Integer> {
    public UserStudent findByUser(String user);
    public UserStudent findByUserAndPass(String user, String pass);
}
