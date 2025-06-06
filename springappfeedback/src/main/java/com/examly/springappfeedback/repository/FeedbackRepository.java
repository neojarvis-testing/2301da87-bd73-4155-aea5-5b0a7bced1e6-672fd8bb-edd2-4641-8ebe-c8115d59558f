package com.examly.springappfeedback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springappfeedback.model.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback,Long>{
    List<Feedback> findByUser_UserId(Long userId);
}
