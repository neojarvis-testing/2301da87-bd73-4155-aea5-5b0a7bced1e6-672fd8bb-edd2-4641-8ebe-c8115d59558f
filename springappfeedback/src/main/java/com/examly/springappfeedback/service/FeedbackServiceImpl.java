package com.examly.springappfeedback.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springappfeedback.config.UserClient;
import com.examly.springappfeedback.config.UserDTO;
import com.examly.springappfeedback.config.WiFiSchemeClient;
import com.examly.springappfeedback.model.Feedback;
import com.examly.springappfeedback.repository.FeedbackRepository;

@Service
public class FeedbackServiceImpl implements FeedbackService{
    @Autowired
    private FeedbackRepository feedbackRepository;
    @Autowired
    private WiFiSchemeClient wiFiSchemeClient; 
    @Autowired
    private UserClient userClient;

    @Override
    public Feedback creatFeedback(Feedback feedback) {
        feedback.setDate(LocalDate.now());
        return feedbackRepository.save(feedback);
    }

    @Override
    public Optional<Feedback> getFeedbackById(Long feedbackId) {
       Optional<Feedback> feedbackOpt = feedbackRepository.findById(feedbackId);
       feedbackOpt.ifPresent(fb->en);
       return feedbackOpt;
    }

    @Override
    public List<Feedback> getAllFeedbacks() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllFeedbacks'");
    }

    @Override
    public boolean deleteFeedback(Long feedbackId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteFeedback'");
    }

    @Override
    public List<Feedback> getFeedbackByUserId(Long userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFeedbackByUserId'");
    }
    private void enrichFeedback(Feedback feedback){
        try {
            UserDTO userDTO = userClient.getUserById(feedback.getUserId());
            UserDTO user = 
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
