package com.examly.springappwifi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springappwifi.model.WiFiSchemeRequest;
import com.examly.springappwifi.repository.WiFiSchemeRequestRepository;

@Service
public class WiFiSchemeRequestServiceImpl implements WiFiSchemeRequestService{

    @Autowired
    private WiFiSchemeRequestRepository requestRepo;
    @Override
    public WiFiSchemeRequest addWiFiSchemeRequest(WiFiSchemeRequest request) {
        return requestRepo.save(request);
    }

    @Override
    public Optional<WiFiSchemeRequest> getWiFiSchemeRequestById(Long id) {
        return requestRepo.findById(id);
    }

    @Override
    public List<WiFiSchemeRequest> getAllWiFiSchemeRequests() {
        return requestRepo.findAll();   
    }

    @Override
    public WiFiSchemeRequest updateWiFiSchemeRequest(Long id, WiFiSchemeRequest request) {
        request.setWifiSchemeRequestId(id);
        return requestRepo.save(request);  
    }

    @Override
    public boolean deleteWiFiSchemeRequest(Long id) {
        if(requestRepo.existsById(id)){
            requestRepo.deleteById(id);
            return true;
        }  
        return false;
    }

    @Override
    public List<WiFiSchemeRequest> getWiFiSchemeRequestsByUserId(Long userId) {
        return requestRepo.findByUserId(userId);  
    }
    
}
