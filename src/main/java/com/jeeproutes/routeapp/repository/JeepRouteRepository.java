package com.jeeproutes.routeapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeeproutes.routeapp.model.JeepRoutes;
import com.jeeproutes.routeapp.model.JeepRoutesById;

public interface JeepRouteRepository extends JpaRepository<JeepRoutes, JeepRoutesById>{
    List<JeepRoutes> findByJeepcodeAndRoutename(String jeepcode, String routename);
    List<JeepRoutes> findByJeepcode(String jeepcode);
}
