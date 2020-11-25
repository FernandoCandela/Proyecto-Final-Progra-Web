package edu.ulima.persistencia;
import edu.ulima.entidad.UserTeacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTeacherRepositorio extends JpaRepository<UserTeacher,Integer> {
    public UserTeacher findByUser(String user);

}
