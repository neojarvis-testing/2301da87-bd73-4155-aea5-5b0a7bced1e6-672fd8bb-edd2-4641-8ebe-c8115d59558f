package com.examly.springappfeedback.model;

import java.time.LocalDate;

import com.examly.springappfeedback.config.UserDTO;
import com.examly.springappfeedback.config.WiFiSchemeDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedbackId;
    private String feedbackText;
    private LocalDate date;
    private Long userId;
    @Transient
    private UserDTO userDTO;
    @Transient
    private WiFiSchemeDTO wiFiSchemeDTO;
    private Long wifiSchemeId;
    private String category;
    public Long getFeedbackId() {
        return feedbackId;
    }
    public void setFeedbackId(Long feedbackId) {
        this.feedbackId = feedbackId;
    }
    public String getFeedbackText() {
        return feedbackText;
    }
    public void setFeedbackText(String feedbackText) {
        this.feedbackText = feedbackText;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public Long getWifiSchemeId() {
        return wifiSchemeId;
    }
    public void setWifiSchemeId(Long wifiSchemeId) {
        this.wifiSchemeId = wifiSchemeId;
    }
    public UserDTO getUserDTO() {
        return userDTO;
    }
    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
    public WiFiSchemeDTO getWiFiSchemeDTO() {
        return wiFiSchemeDTO;
    }
    public void setWiFiSchemeDTO(WiFiSchemeDTO wiFiSchemeDTO) {
        this.wiFiSchemeDTO = wiFiSchemeDTO;
    }
    
}
