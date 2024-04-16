package com.jeeproutes.routeapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeeproutes.routeapp.model.JeepRoutes;
import com.jeeproutes.routeapp.model.JeepRoutesId;

public interface JeepRouteRepo extends JpaRepository<JeepRoutes, JeepRoutesId>{
    List<JeepRoutes> findByJeepcodeAndRoutename(String jeepcode, String routename);
    List<JeepRoutes> findByJeepcode(String jeepcode);
}
