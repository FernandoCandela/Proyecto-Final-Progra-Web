
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
@Entity(name = "ECAREER")
@Table(name = "TCAREER")
public class Career implements Serializable {
    
    @Id
    @Column(name = "ID",nullable = false )
    private int  id ;
    
    @Column(name = "NAME",length = 25 ,nullable = false )
    private String name;
    
    
    
}
