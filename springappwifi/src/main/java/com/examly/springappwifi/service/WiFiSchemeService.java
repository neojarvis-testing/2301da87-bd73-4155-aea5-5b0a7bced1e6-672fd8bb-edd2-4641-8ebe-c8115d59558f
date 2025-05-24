package com.examly.springappwifi.service;

import java.util.List;
import java.util.Optional;

import com.examly.springappwifi.model.WiFiScheme;

public interface WiFiSchemeService {
    WiFiScheme addWiFiScheme(WiFiScheme scheme);
    Optional<WiFiScheme> getWiFiSchemeById(Long id);
    List<WiFiScheme> getAllWiFiSchemes();
    WiFiScheme updateWiFiScheme(Long id, WiFiScheme scheme);
    WiFiScheme deleteWiFiScheme(Long id);
}
