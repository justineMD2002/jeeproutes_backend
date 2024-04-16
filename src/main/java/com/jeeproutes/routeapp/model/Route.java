package com.jeeproutes.routeapp.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import jakarta.persistence.*;

@Entity
@Table(name = "route")
public class Route {
    @Id
    private String routename;

    public Route() {
    }

    public Route(String routename) {
        this.routename = routename;
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
