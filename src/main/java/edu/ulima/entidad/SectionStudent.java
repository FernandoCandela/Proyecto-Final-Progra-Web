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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "ESECTIONSTUDENT")
@Table(name = "TSECTIONSTUDENT")
public class SectionStudent implements Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "SECTION_ID",nullable = false)
    private Section section_id;

    @ManyToOne
    @JoinColumn(name = "STUDENT_ID",nullable = false)
    private Student student_id;

}
