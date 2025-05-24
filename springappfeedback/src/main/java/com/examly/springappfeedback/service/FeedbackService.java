package com.examly.springappfeedback.service;

import java.util.List;
import java.util.Optional;

import com.examly.springappfeedback.model.Feedback;

public interface FeedbackService {
    Feedback creatFeedback(Feedback feedback);
    Optional<Feedback> getFeedbackById(Long feedbackId);
    List<Feedback> getAllFeedbacks();
    boolean deleteFeedback(Long feedbackId);
    List<Feedback> getFeedbackByUserId(Long userId);
}
