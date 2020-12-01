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

    @ManyToOne
    @JoinColumn(name = "GENDER_ID", nullable = false)
    private Gender gender_id;

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID", nullable = false)
    private Country country_id;

    @ManyToOne
    @JoinColumn(name = "TEACHER_TYPE_ID", nullable = false)
    private TeacherType teacher_type_id;

    @Column(name = "PHOTO_URL", length = 100, nullable = false)
    private String photo_url;

    public Teacher() {
    }

    public Teacher(Integer id, Integer code, String names, String last_names, String email, String personal_email, Gender gender_id, Country country_id, TeacherType teacher_type_id, String photo_url) {
        this.id = id;
        this.code = code;
        this.names = names;
        this.last_names = last_names;
        this.email = email;
        this.personal_email = personal_email;
        this.gender_id = gender_id;
        this.country_id = country_id;
        this.teacher_type_id = teacher_type_id;
        this.photo_url = photo_url;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLast_names() {
        return last_names;
    }

    public void setLast_names(String last_names) {
        this.last_names = last_names;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPersonal_email() {
        return personal_email;
    }

    public void setPersonal_email(String personal_email) {
        this.personal_email = personal_email;
    }

    public Gender getGender_id() {
        return gender_id;
    }

    public void setGender_id(Gender gender_id) {
        this.gender_id = gender_id;
    }

    public Country getCountry_id() {
        return country_id;
    }

    public void setCountry_id(Country country_id) {
        this.country_id = country_id;
    }

    public TeacherType getTeacher_type_id() {
        return teacher_type_id;
    }

    public void setTeacher_type_id(TeacherType teacher_type_id) {
        this.teacher_type_id = teacher_type_id;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }
    
    

}
