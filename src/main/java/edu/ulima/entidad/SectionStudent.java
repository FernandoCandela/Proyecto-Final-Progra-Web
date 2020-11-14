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
@Entity(name = "ESECTIONSTUDENT")
@Table(name = "TSECTIONSTUDENT")
public class SectionStudent implements Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "SECTION_ID", nullable = false)
    private Integer section_id;

    @Column(name = "STUDENT_ID", nullable = false)
    private Integer student_id;

}
