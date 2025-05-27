package com.examly.springappfeedback.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springappfeedback.config.UserClient;
import com.examly.springappfeedback.config.WiFiSchemeClient;
import com.examly.springappfeedback.dto.UserDTO;
import com.examly.springappfeedback.dto.WiFiSchemeDTO;
import com.examly.springappfeedback.model.Feedback;
import com.examly.springappfeedback.service.FeedbackService;

import feign.FeignException;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {
    private final FeedbackService feedbackService;
    private final UserClient userClient;
    private final WiFiSchemeClient wiFiSchemeClient;
    public FeedbackController(FeedbackService feedbackService,UserClient userClient, WiFiSchemeClient wiFiSchemeClient){
        this.feedbackService=feedbackService;
        this.userClient=userClient;
        this.wiFiSchemeClient=wiFiSchemeClient;
    }
    @PostMapping
    public ResponseEntity<?> createFeedback(@RequestBody Feedback feedback){
        UserDTO userDTO;
        try{
            userDTO = userClient.getUserById(feedback.getUserId());
        }
        catch(FeignException.NotFound e){
            return ResponseEntity.badRequest().body("In valid user Id");
        }
        catch(Exception e){
            return ResponseEntity.badRequest().body("In valid user Id");
        }
        WiFiSchemeDTO wiFiSchemeDTO;
        try{
            wiFiSchemeDTO = wiFiSchemeClient.getWiFiSchemeById(feedback.getWifiSchemeId());
        }
        catch(Exception e){
            return ResponseEntity.badRequest().body("Invalid WiFi Scheme ID");
        }
        Feedback savedFeedback = feedbackService.creatFeedback(feedback);
        return ResponseEntity.ok(savedFeedback);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getFeedbackById(@PathVariable Long id){
        Optional<Feedback> feedback = feedbackService.getFeedbackById(id);
        return feedback.<ResponseEntity<?>>map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Feedback>> getFeedbackByUser(@PathVariable Long userId){
        List<Feedback> feedbacks= feedbackService.getFeedbackByUserId(userId);
        return ResponseEntity.ok(feedbacks);
    }
    @GetMapping
    public ResponseEntity<List<Feedback>> getAllFeedbacks(){
        List<Feedback> feedbacks=feedbackService.getAllFeedbacks();
        return ResponseEntity.ok(feedbacks);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?>deleteFeedback(@PathVariable long id){
        boolean deleted = feedbackService.deleteFeedback(id);
        if(deleted){
            return ResponseEntity.ok("Feedback deleted successfully");
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}
