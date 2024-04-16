package com.jeeproutes.routeapp.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import jakarta.persistence.*;

@Entity
@Table(name = "jeep_route")
@IdClass(JeepRoutesId.class)
public class JeepRoutes {
    @Id
    String jeepcode;

    @Id
    String routename;

    public JeepRoutes() {
    }

    public JeepRoutes(String jeepcode, String routename) {
        this.jeepcode = jeepcode;
        this.routename = routename;
    }

    public String getJeepcode() {
        return jeepcode;
    }

    public void setJeepcode(String jeepcode) {
        this.jeepcode = jeepcode;
    }

    public String getRoutename() {
        return routename;
    }

    public void setRoutename(String routename) {
        this.routename = routename;
    }

    @Override
    public String toString() {
        ObjectWriter mapper = (new ObjectMapper()).writerWithDefaultPrettyPrinter();

        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return "Transaction failed";
        }
    }

}
