
package edu.ulima.clienterest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SectionTeacher1 {
    private Integer section_id;
    private Integer teacher_id;
}
