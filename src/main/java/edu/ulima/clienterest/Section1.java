
package edu.ulima.clienterest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;



//@Data
//@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Section1 {

    private Integer code;
    private String course_name;
    private Integer course_code;
    private String carrer_name;
    private String period_name;
    private String teacher_name;

    public Section1(Integer code, String course_name, Integer course_code, String carrer_name, String period_name, String teacher_name) {
        this.code = code;
        this.course_name = course_name;
        this.course_code = course_code;
        this.carrer_name = carrer_name;
        this.period_name = period_name;
        this.teacher_name = teacher_name;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public void setCourse_code(Integer course_code) {
        this.course_code = course_code;
    }

    public void setCarrer_name(String carrer_name) {
        this.carrer_name = carrer_name;
    }

    public void setPeriod_name(String period_name) {
        this.period_name = period_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }
    
    

    public Integer getCode() {
        return code;
    }

    public String getCourse_name() {
        return course_name;
    }

    public Integer getCourse_code() {
        return course_code;
    }

    public String getCarrer_name() {
        return carrer_name;
    }

    public String getPeriod_name() {
        return period_name;
    }

    public String getTeacher_name() {
        return teacher_name;
    }
    
    
    
    
    
}
