package com.jeeproutes.routeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeeproutes.routeapp.model.Jeep;

public interface JeepRepository extends JpaRepository<Jeep,String>{
    
}
