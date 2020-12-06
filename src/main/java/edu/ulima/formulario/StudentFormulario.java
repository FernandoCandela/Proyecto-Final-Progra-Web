package edu.ulima.formulario;

import java.io.Serializable;
import lombok.Data;

@Data
public class StudentFormulario implements Serializable {

    private String code;
    private String names;
    private String last_names;
    private String email;
    private String personal_email;
    private String gender_id;
    private String country_id;
    private String career_id;
    private String tw_user;
    private String tw_pass;
    private String ad_user;
    private String photo_url;

}
