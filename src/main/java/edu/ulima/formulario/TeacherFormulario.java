
package edu.ulima.formulario;

import java.io.Serializable;
import lombok.Data;
@Data
public class TeacherFormulario implements Serializable {
    private String code;
    private String names;
    private String last_names;
    private String email;
    private String personal_email;
    private String gender_id;
    private String country_id;
    private String teacher_type_id;
    private String photo_url;
}
