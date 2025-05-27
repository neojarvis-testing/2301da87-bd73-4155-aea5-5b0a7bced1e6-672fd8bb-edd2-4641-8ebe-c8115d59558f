package com.examly.springappwifi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springappwifi.model.WiFiSchemeRequest;
import com.examly.springappwifi.service.WiFiSchemeRequestService;

import jakarta.ws.rs.core.Response;

@RestController
@RequestMapping("/api/wifirequests")
@CrossOrigin
public class WiFiSchemeRequestController {
    @Autowired
    private WiFiSchemeRequestService requestService;

    @PostMapping
    // @PreAuthorize("hasRole('USER)")
    public ResponseEntity<WiFiSchemeRequest> addWiFiSchemeRequest(@RequestBody WiFiSchemeRequest request){
        WiFiSchemeRequest created = requestService.addWiFiSchemeRequest(request);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping
    // @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<WiFiSchemeRequest>> getAllWiFiSchemeRequests(){
        return ResponseEntity.ok(requestService.getAllWiFiSchemeRequests());
    }
    @GetMapping("/{id}")
    public ResponseEntity<WiFiSchemeRequest> getWiFiSchemeRequestById(@PathVariable Long id){
        return requestService.getWiFiSchemeRequestById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    // @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<WiFiSchemeRequest> updateRequest(@PathVariable Long id,@RequestBody WiFiSchemeRequest request){
        return ResponseEntity.ok(requestService.updateWiFiSchemeRequest(id, request));
    }
    @DeleteMapping("/{id}")
    // @PreAuthorize("hasAnyRole('USER',ADMIN)")
    public ResponseEntity<Void> deleteRequest(@PathVariable Long id){
        boolean deleted = requestService.deleteWiFiSchemeRequest(id);
        return deleted?ResponseEntity.noContent().build():ResponseEntity.notFound().build();
    }
    @GetMapping("/user/{userId}")
    // @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<WiFiSchemeRequest>> getRequestByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(requestService.getWiFiSchemeRequestsByUserId(userId));
    }
}
