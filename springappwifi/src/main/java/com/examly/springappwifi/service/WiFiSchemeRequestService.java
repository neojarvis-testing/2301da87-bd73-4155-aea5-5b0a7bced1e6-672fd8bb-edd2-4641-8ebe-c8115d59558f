package com.examly.springappwifi.service;

import java.util.List;
import java.util.Optional;

import com.examly.springappwifi.model.WiFiSchemeRequest;

public interface WiFiSchemeRequestService {
    WiFiSchemeRequest addWiFiSchemeRequest(WiFiSchemeRequest request);
    Optional <WiFiSchemeRequest> getWiFiSchemeRequestById(Long id);
    List<WiFiSchemeRequest> getAllWiFiSchemeRequests();
    WiFiSchemeRequest updateWiFiSchemeRequest(Long id, WiFiSchemeRequest request);
    boolean deleteWiFiSchemeRequest(Long id);
    List<WiFiSchemeRequest> getWiFiSchemeRequestsByUserId(Long userId);
}
