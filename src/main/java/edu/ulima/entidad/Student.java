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
@Entity(name = "ESTUDENT")
@Table(name = "TSTUDENT")
public class Student implements Serializable {

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

    @Column(name = "TW_USER", length = 25, nullable = true)
    private String tw_user;

    @Column(name = "TW_PASS", length = 25, nullable = true)
    private String tw_pass;

    @Column(name = "AD_USER", length = 25, nullable = true)
    private String ad_user;

    @ManyToOne
    @JoinColumn(name = "GENDER_ID", nullable = false)
    private Gender gender_id;

    @ManyToOne
    @JoinColumn(name = "CAREER_ID", nullable = false)
    private Career career_id;

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID", nullable = false)
    private Country country_id;

    @Column(name = "PHOTO_URL", length = 100, nullable = false)
    private String photo_url;

}
