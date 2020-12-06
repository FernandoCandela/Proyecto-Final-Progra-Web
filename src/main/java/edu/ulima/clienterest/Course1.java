package edu.ulima.clienterest;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Course1 {

    private Integer code;
    private String name;
    private String carrer_name;

    public Course1(Integer code, String name, String carrer_name) {
        this.code = code;
        this.name = name;
        this.carrer_name = carrer_name;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCarrer_name(String carrer_name) {
        this.carrer_name = carrer_name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getCarrer_name() {
        return carrer_name;
    }
}
