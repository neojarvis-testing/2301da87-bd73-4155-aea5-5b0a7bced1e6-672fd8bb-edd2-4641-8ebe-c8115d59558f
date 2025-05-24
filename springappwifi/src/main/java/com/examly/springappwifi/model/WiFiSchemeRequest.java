package com.examly.springappwifi.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Entity
public class WiFiSchemeRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wifiSchemeRequestId;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    @ManyToOne
    @JoinColumn(name="wifiSchemeId")
    private WiFiScheme wiFiScheme;
    private LocalDate requesDate;
    private String status;
    private String comments;

    @Lob
    private String proof;
    private String streetName;
    private String landmark;
    private String city;
    private String state;
    private String zipCode;
    private LocalDate preferredSetupDate;
    private String timeSlot;
    
    public Long getWifiSchemeRequestId() {
        return wifiSchemeRequestId;
    }


    public void setWifiSchemeRequestId(Long wifiSchemeRequestId) {
        this.wifiSchemeRequestId = wifiSchemeRequestId;
    }


    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }


    public WiFiScheme getWiFiScheme() {
        return wiFiScheme;
    }


    public void setWiFiScheme(WiFiScheme wiFiScheme) {
        this.wiFiScheme = wiFiScheme;
    }


    public LocalDate getRequesDate() {
        return requesDate;
    }


    public void setRequesDate(LocalDate requesDate) {
        this.requesDate = requesDate;
    }


    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }


    public String getComments() {
        return comments;
    }


    public void setComments(String comments) {
        this.comments = comments;
    }


    public String getProof() {
        return proof;
    }


    public void setProof(String proof) {
        this.proof = proof;
    }


    public String getStreetName() {
        return streetName;
    }


    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }


    public String getLandmark() {
        return landmark;
    }


    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }


    public String getCity() {
        return city;
    }


    public void setCity(String city) {
        this.city = city;
    }


    public String getState() {
        return state;
    }


    public void setState(String state) {
        this.state = state;
    }


    public String getZipCode() {
        return zipCode;
    }


    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }


    public LocalDate getPreferredSetupDate() {
        return preferredSetupDate;
    }


    public void setPreferredSetupDate(LocalDate preferredSetupDate) {
        this.preferredSetupDate = preferredSetupDate;
    }


    public String getTimeSlot() {
        return timeSlot;
    }


    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }


    @Override
    public String toString() {
        return "WiFiSchemeRequest [wifiSchemeRequestId=" + wifiSchemeRequestId + ", user=" + user + ", wiFiScheme="
                + wiFiScheme + ", requesDate=" + requesDate + ", status=" + status + ", comments=" + comments
                + ", proof=" + proof + ", streetName=" + streetName + ", landmark=" + landmark + ", city=" + city
                + ", state=" + state + ", zipCode=" + zipCode + ", preferredSetupDate=" + preferredSetupDate
                + ", timeSlot=" + timeSlot + "]";
    }

    
}
