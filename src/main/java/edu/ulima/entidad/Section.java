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
@Entity(name = "ESECTION")
@Table(name = "TSECTION")
public class Section implements Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "CODE", nullable = false)
    private Integer code;

    @Column(name = "COURSE_ID", nullable = false)
    private Integer course_id;

    @Column(name = "PERIOD_ID", nullable = false)
    private Integer period_id;

}
