package com.jeeproutes.routeapp.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import jakarta.persistence.*;

@Entity
@Table(name = "jeep")
public class Jeep {
    @Id
    private String jeepcode;

    public Jeep() {
    }

    public Jeep(String jeepcode) {
        this.jeepcode = jeepcode;
    }

    public String getJeepcode() {
        return jeepcode;
    }

    public void setJeepcode(String jeepcode) {
        this.jeepcode = jeepcode;
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
