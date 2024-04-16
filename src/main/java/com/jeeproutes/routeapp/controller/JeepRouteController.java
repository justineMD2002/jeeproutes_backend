package com.jeeproutes.routeapp.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeeproutes.routeapp.model.HelperRoute;
import com.jeeproutes.routeapp.model.JeepRoutes;
import com.jeeproutes.routeapp.service.JeepRouteService;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@CrossOrigin
public class JeepRouteController {
    
    @Autowired
    private final JeepRouteService jeepRouteService;

    public JeepRouteController(JeepRouteService jeepRouteService) {
        this.jeepRouteService = jeepRouteService;
    }

    @GetMapping("/get-all-routes")
    public Map<String, List<String>> getRoutesByJeepCode() {
        return jeepRouteService.getAllJeepRoutes();
    }

    @GetMapping("/get/{jeepcode}")
    public List<String> getJeepRoute(@PathVariable String jeepcode) {
        return jeepRouteService.getRouteByJeepCode(jeepcode);
    }

    @PostMapping("/get-multiple-jeeproutes")
    public List<HelperRoute> getMultipleRoutes(String jeepcodes) {
        return jeepRouteService.getMultipleJeepRoutes(jeepcodes);
    }

    @PostMapping("/add-jeeproute")
    public int addJeepRoute(String jeepcode, String route) {
        return jeepRouteService.addJeepRoute(jeepcode, route);
    }

    @PutMapping("/change-route/{jeepcode}")
    public int changeJeepRoute(@PathVariable String jeepcode, String route) {
        return jeepRouteService.changeRoute(jeepcode, route);
    }

    @DeleteMapping("/delete-route/{jeepcode}")
    public int deleteJeepRoute(@PathVariable String jeepcode, String route) {
        return jeepRouteService.deleteJeepRoute(jeepcode, route);
    }
    
}
