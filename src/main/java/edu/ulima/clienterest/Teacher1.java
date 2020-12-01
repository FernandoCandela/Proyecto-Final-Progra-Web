package edu.ulima.clienterest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Teacher1 {

    private Integer code;
    private String names;
    private String last_names;
    private String gender_name;
    private String teacher_type;
}
