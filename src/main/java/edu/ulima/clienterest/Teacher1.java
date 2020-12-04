package edu.ulima.clienterest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Teacher1 {

    private Integer code;
    private String names;
    private String last_names;
    private String gender_name;
    private String teacher_type;    

    public Teacher1(Integer code, String names, String last_names, String gender_name, String teacher_type) {
        this.code = code;
        this.names = names;
        this.last_names = last_names;
        this.gender_name = gender_name;
        this.teacher_type = teacher_type;
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

    public void setGender_name(String gender_name) {
        this.gender_name = gender_name;
    }

    public void setTeacher_type(String teacher_type) {
        this.teacher_type = teacher_type;
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

    public String getGender_name() {
        return gender_name;
    }

    public String getTeacher_type() {
        return teacher_type;
    }
    
    
    
    
    
}
