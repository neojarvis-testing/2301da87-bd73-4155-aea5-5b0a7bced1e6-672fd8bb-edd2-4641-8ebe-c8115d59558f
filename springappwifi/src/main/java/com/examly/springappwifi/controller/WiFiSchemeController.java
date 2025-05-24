package com.examly.springappwifi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springappwifi.model.WiFiScheme;
import com.examly.springappwifi.service.WiFiSchemeService;

@RestController
@RequestMapping("/api/wifischemes")
@CrossOrigin
public class WiFiSchemeController {
    @Autowired
    private WiFiSchemeService schemeService;
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<WiFiScheme> addWiFiScheme(@RequestBody WiFiScheme scheme){
        return new ResponseEntity<>(schemeService.addWiFiScheme(scheme),HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<WiFiScheme>> getAllWiFiScheme(){
        return ResponseEntity.ok(schemeService.getAllWiFiSchemes());
    }
    @GetMapping("/{id}")
    public ResponseEntity<WiFiScheme> getWiFiSchemeById(@PathVariable Long id){
        return schemeService.getWiFiSchemeById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<WiFiScheme> updateWiFiScheme(@PathVariable Long id, @RequestBody WiFiScheme scheme){
        return ResponseEntity.ok(schemeService.updateWiFiScheme(id, scheme));
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteWiFiScheme(@PathVariable Long id){
        schemeService.deleteWiFiScheme(id);
        return ResponseEntity.noContent().build();
    }

}
