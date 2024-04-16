package com.jeeproutes.routeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeeproutes.routeapp.model.Jeep;

public interface JeepRepo extends JpaRepository<Jeep,String>{
    
}
