
package edu.ulima.clienterest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Course1 {

    private Integer code;
    private String name;
    private String carrer_name;
}
