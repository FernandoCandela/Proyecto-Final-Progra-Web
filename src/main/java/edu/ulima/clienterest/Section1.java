
package edu.ulima.clienterest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Section1 {

    private Integer code;
    private String course_name;
    private Integer course_code;
    private String carrer_name;
    private String period_name;
}
