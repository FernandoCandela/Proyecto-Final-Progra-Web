package edu.ulima.entidad;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "ETEACHER")
@Table(name = "TTEACHER")
public class Teacher implements Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "CODE", nullable = false)
    private Integer code;

    @Column(name = "NAMES", length = 50, nullable = false)
    private String names;

    @Column(name = "LAST_NAMES", length = 50, nullable = false)
    private String last_names;

    @Column(name = "EMAIL", length = 50, nullable = false)
    private String email;

    @Column(name = "PERSONAL_EMAIL", length = 50, nullable = false)
    private String personal_email;

    @Column(name = "PHOTO_URL", length = 100, nullable = false)
    private String photo_url;

    @Column(name = "GENDER_ID", nullable = false)
    private Integer gender_id;

    @Column(name = "COUNTRY_ID", nullable = false)
    private Integer country_id;

    @Column(name = "TEACHER_TYPE_ID", nullable = false)
    private Integer teacher_type_id;

}
