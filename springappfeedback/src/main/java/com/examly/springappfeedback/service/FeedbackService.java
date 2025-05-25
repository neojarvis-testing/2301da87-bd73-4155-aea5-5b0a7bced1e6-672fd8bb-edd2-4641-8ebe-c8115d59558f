package com.examly.springappfeedback.service;

import java.util.List;
import java.util.Optional;

import com.examly.springappfeedback.model.Feedback;

public interface FeedbackService {
    Feedback creatFeedback(Feedback feedback);
    Optional<Feedback> getFeedbackById(Long id);
    List<Feedback> getAllFeedbacks();
    boolean deleteFeedback(Long id);
    List<Feedback> getFeedbackByUserId(Long userId);
}
