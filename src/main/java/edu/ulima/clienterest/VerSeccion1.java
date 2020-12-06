/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulima.clienterest;

/**
 *
 * @author Camila
 */
public class VerSeccion1 {
    
    private Integer code;
    private String names;
    private String last_names;
    private String ad_user;
    private String tw_user;
    private String tw_pass;

    public VerSeccion1(Integer code, String names, String last_names, String ad_user, String tw_user, String tw_pass) {
        this.code = code;
        this.names = names;
        this.last_names = last_names;
        this.ad_user = ad_user;
        this.tw_user = tw_user;
        this.tw_pass = tw_pass;
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

    public void setAd_user(String ad_user) {
        this.ad_user = ad_user;
    }

    public void setTw_user(String tw_user) {
        this.tw_user = tw_user;
    }

    public void setTw_pass(String tw_pass) {
        this.tw_pass = tw_pass;
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

    public String getAd_user() {
        return ad_user;
    }

    public String getTw_user() {
        return tw_user;
    }

    public String getTw_pass() {
        return tw_pass;
    }
    
    
    
    
}
