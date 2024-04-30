package com.jeeproutes.routeapp.service;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeeproutes.routeapp.model.HelperClass;
import com.jeeproutes.routeapp.model.Jeep;
import com.jeeproutes.routeapp.model.JeepRoutes;
import com.jeeproutes.routeapp.model.Route;
import com.jeeproutes.routeapp.repository.JeepRouteRepository;
import com.jeeproutes.routeapp.repository.JeepRepository;
import com.jeeproutes.routeapp.repository.RouteRepository;

@Service
public class JeepRouteService {
    @Autowired
    private JeepRouteRepository jeepRouteRepo;
    @Autowired
    private JeepRepository jeepRepo;
    @Autowired
    private RouteRepository routeRepo;

    public Map<String,List<String>> getAllJeepRoutes() {
        List<JeepRoutes> allRoutes = jeepRouteRepo.findAll();

        Map<String, List<String>> groupedByJeepCode = 
            allRoutes.stream().collect(Collectors.groupingBy(JeepRoutes::getJeepcode,
                Collectors.mapping(JeepRoutes::getRoutename, Collectors.toList())));
        return groupedByJeepCode;
    }

    public List<String> getRouteByJeepCode(String jeepcode) {
        List<JeepRoutes> routes = jeepRouteRepo.findByJeepcode(jeepcode);

        List<String> routeByJeepcode =
            routes.stream().collect(Collectors.mapping(JeepRoutes::getRoutename, Collectors.toList()));
        
        return routeByJeepcode;
    }

    public List<HelperClass> getMultipleJeepRoutes(String jeepcodes) {
        List<HelperClass> helperRoutes = new ArrayList<>();
        List<String> jeepList = Arrays.asList(jeepcodes.split(","));
        
        for (String jeep : jeepList) {
            if (addJeepCode(jeep) == 0) {
                List<String> routes = getRouteByJeepCode(jeep);
                HelperClass helperRoute = new HelperClass(jeep, routes);
                helperRoutes.add(helperRoute);
            }
        }
        
        return helperRoutes;
    }
    
    

    public int addJeepCode(String jeepcode) {
        try {
            jeepRepo.findById(jeepcode).get();
        } catch (Exception e) {
            jeepRepo.save(new Jeep(jeepcode));
            return 1;
        }
        return 0;
    }

    public int addJeepRoute(String jeepcode, String route) {
        addJeepCode(jeepcode);
        List<String> routeList = Arrays.asList(route.split(","));
        if(!getRouteByJeepCode(jeepcode).containsAll(routeList)) {
            for (String r : routeList) {
                if(jeepRouteRepo.findByJeepcodeAndRoutename(jeepcode, r).isEmpty()) {
                    addRoute(r);
                    jeepRouteRepo.save(new JeepRoutes(jeepcode, r));
                }
            }    
            return 1;
        }
        return 0;
    }

    public int addRoute(String route) {
        try {
            routeRepo.findById(route).get();
        } catch (Exception e) {
            routeRepo.save(new Route(route));
            return 1;
        }
        return 0;
    }

    public int changeRoute(String jeepcode, String route) {
        if(addJeepCode(jeepcode)==0) {
            List<JeepRoutes> existingRoute = jeepRouteRepo.findByJeepcode(jeepcode);
            jeepRouteRepo.deleteAllInBatch(existingRoute);
            addJeepRoute(jeepcode, route);
            return 1;
        }
        return 0;
    }

    public int deleteJeepRoute(String jeepcode, String route) {
        if(addJeepCode(jeepcode)==0) {
            List<String> routeList = Arrays.asList(route.split(","));
            for (String r : routeList) {
                JeepRoutes jroute = (jeepRouteRepo.findByJeepcodeAndRoutename(jeepcode, r)==null) ? null 
                    : jeepRouteRepo.findByJeepcodeAndRoutename(jeepcode, r).get(0);
                jeepRouteRepo.delete(jroute);
            }
            return 1;
        }
        return 0;
    }
}
