package com.jeeproutes.routeapp.model;

import java.io.Serializable;

public class JeepRoutesId implements Serializable {
    private String jeepcode;
    private String routename;
    public JeepRoutesId() {
    }
    public JeepRoutesId(String jeepcode, String routename) {
        this.jeepcode = jeepcode;
        this.routename = routename;
    }
}
