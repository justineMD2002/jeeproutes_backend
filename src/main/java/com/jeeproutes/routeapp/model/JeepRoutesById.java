package com.jeeproutes.routeapp.model;

import java.io.Serializable;

public class JeepRoutesById implements Serializable {
    private String jeepcode;
    private String routename;
    public JeepRoutesById() {
    }
    public JeepRoutesById(String jeepcode, String routename) {
        this.jeepcode = jeepcode;
        this.routename = routename;
    }
}
