
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
@Entity(name = "ECOUNTRY")
@Table(name = "TCOUNTRY")
public class Country implements Serializable{
    
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;
    
    @Column(name = "NAME",length = 30 ,nullable = false)
    private String name;
    
}
