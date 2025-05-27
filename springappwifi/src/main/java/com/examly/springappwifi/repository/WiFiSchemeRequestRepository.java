package com.examly.springappwifi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springappwifi.model.WiFiSchemeRequest;

@Repository
public interface WiFiSchemeRequestRepository extends JpaRepository<WiFiSchemeRequest,Long>{
    List<WiFiSchemeRequest> findByUser_UserId(Long userId);
}
