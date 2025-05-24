package com.examly.springappwifi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springappwifi.model.WiFiScheme;
import com.examly.springappwifi.repository.WiFiSchemeRepository;
@Service
public class WiFiSchemeServiceImpl implements WiFiSchemeService{
    @Autowired
    private WiFiSchemeRepository schemeRepo;
    @Override
    public WiFiScheme addWiFiScheme(WiFiScheme scheme) {
        return schemeRepo.save(scheme);
    }

    @Override
    public Optional<WiFiScheme> getWiFiSchemeById(Long id) {
        return schemeRepo.findById(id);
    }

    @Override
    public List<WiFiScheme> getAllWiFiSchemes() {
        return schemeRepo.findAll();
    }

    @Override
    public WiFiScheme updateWiFiScheme(Long id, WiFiScheme scheme) {
       scheme.setWifiSchemeId(id);
       return schemeRepo.save(scheme);
    }

    @Override
    public WiFiScheme deleteWiFiScheme(Long id) {
       WiFiScheme scheme = schemeRepo.findById(id).orElseThrow();
       schemeRepo.delete(scheme);
       return scheme;
    }
    
}
