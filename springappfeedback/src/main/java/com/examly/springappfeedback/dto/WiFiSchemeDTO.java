package com.examly.springappfeedback.dto;

public class WiFiSchemeDTO {
    private Long wifiSchemeId;
    private String schemeName;
    private String description;
    private String region;
    private String speed;
    private String dataLimit;
    private String fee;
    private String availabilityStatus;
    public Long getWifiSchemeId() {
        return wifiSchemeId;
    }
    public void setWifiSchemeId(Long wifiSchemeId) {
        this.wifiSchemeId = wifiSchemeId;
    }
    public String getSchemeName() {
        return schemeName;
    }
    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {
        this.region = region;
    }
    public String getSpeed() {
        return speed;
    }
    public void setSpeed(String speed) {
        this.speed = speed;
    }
    public String getDataLimit() {
        return dataLimit;
    }
    public void setDataLimit(String dataLimit) {
        this.dataLimit = dataLimit;
    }
    public String getFee() {
        return fee;
    }
    public void setFee(String fee) {
        this.fee = fee;
    }
    public String getAvailabilityStatus() {
        return availabilityStatus;
    }
    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }
    
}
