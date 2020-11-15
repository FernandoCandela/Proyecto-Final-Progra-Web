
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
@Entity(name = "EUSER")
@Table(name = "TUSER")
public class UserStudent implements Serializable{
    
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "USER_ID",nullable = false)
    private User user_id;
    
    @ManyToOne
    @JoinColumn(name = "STUDENT_ID",nullable = false)
    private Student student_id;
    
}
