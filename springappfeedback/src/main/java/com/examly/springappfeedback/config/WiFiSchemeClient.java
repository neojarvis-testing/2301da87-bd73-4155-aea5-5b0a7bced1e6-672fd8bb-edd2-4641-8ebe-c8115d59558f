package com.examly.springappfeedback.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.examly.springappfeedback.dto.WiFiSchemeDTO;

@FeignClient(name = "springappwifizone")
public interface WiFiSchemeClient {
    @GetMapping("/api/wifischeme/{id}")
    WiFiSchemeDTO getWiFiSchemeById(@PathVariable("id") Long id);
}
