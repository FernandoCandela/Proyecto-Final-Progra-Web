package edu.ulima.entidad;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "EUSER")
@Table(name = "TUSER")
public class UserTeacher implements Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "USER", length = 45, nullable = false)
    private String user;

    @Column(name = "PASS", length = 45, nullable = false)
    private String pass;

    @Column(name = "RESET_KEY", length = 45, nullable = false)
    private String reset_key;

    @Column(name = "ACTIVATION_KEY", length = 45, nullable = false)
    private String activation_key;

    @ManyToOne
    @JoinColumn(name = "USER_ID",nullable = false)
    private User user_id;

    @ManyToOne
    @JoinColumn(name = "TEACHER_ID",nullable = false)
    private Teacher teacher_id;

}
