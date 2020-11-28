package edu.ulima.clienterest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student1 {

    private Integer code;
    private String names;
    private String last_names;
    private String garden_name;
    private String carrer_name;
}
