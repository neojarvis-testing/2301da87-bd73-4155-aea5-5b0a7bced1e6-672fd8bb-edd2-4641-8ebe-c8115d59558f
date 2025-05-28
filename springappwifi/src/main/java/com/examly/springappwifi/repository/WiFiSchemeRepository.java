package com.examly.springappwifi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springappwifi.model.WiFiScheme;

@Repository
public interface WiFiSchemeRepository extends JpaRepository<WiFiScheme,Long>{
    
}
