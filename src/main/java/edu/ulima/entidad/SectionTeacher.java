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
@Entity(name = "ESECTIONTEACHER")
@Table(name = "TSECTIONTEACHER")
public class SectionTeacher implements Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    private Integer ide;

    @ManyToOne
    @JoinColumn(name = "SECTION_ID", nullable = false)
    private Section section_id;

    @ManyToOne
    @JoinColumn(name = "TEACHER_ID", nullable = false)
    private Teacher teacher_id;

    }