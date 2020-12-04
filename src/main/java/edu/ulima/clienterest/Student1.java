package edu.ulima.clienterest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student1 {

    private Integer code;
    private String names;
    private String last_names;
    private String garden_name;
    private String carrer_name;

    public Student1(Integer code, String names, String last_names, String garden_name, String carrer_name) {
        this.code = code;
        this.names = names;
        this.last_names = last_names;
        this.garden_name = garden_name;
        this.carrer_name = carrer_name;
    }

  

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public void setLast_names(String last_names) {
        this.last_names = last_names;
    }

    public void setGarden_name(String garden_name) {
        this.garden_name = garden_name;
    }

    public void setCarrer_name(String carrer_name) {
        this.carrer_name = carrer_name;
    }
    
    
    public Integer getCode() {
        return code;
    }
    public String getNames() {
        return names;
    }
    public String getLast_names() {
        return last_names;
    }
    public String getGarden_name() {
        return garden_name;
    }
    public String getCarrer_name() {
        return carrer_name;
    }
    
}
