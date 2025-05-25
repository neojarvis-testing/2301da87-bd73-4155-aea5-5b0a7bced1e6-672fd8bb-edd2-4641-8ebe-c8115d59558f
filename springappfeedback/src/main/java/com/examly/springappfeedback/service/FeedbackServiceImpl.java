package com.examly.springappfeedback.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springappfeedback.model.Feedback;
import com.examly.springappfeedback.repository.FeedbackRepository;

@Service
public class FeedbackServiceImpl implements FeedbackService{
    private final FeedbackRepository  feedbackRepository;
    @Autowired
    public FeedbackServiceImpl(FeedbackRepository feedbackRepository){
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    public Feedback creatFeedback(Feedback feedback) {
        feedback.setDate(LocalDate.now());
        return feedbackRepository.save(feedback);
    }

    @Override
    public Optional<Feedback> getFeedbackById(Long id) {
        return feedbackRepository.findById(id);
    }

    @Override
    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    @Override
    public boolean deleteFeedback(Long id) {
        if(feedbackRepository.existsById(id)){
            feedbackRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Feedback> getFeedbackByUserId(Long userId) {
        return feedbackRepository.findByUserId(userId);
    }
    
}
