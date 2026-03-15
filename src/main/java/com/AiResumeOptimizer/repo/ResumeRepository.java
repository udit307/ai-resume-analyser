package com.AiResumeOptimizer.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.AiResumeOptimizer.entity.ResumeAnalysis;

public interface ResumeRepository extends JpaRepository<ResumeAnalysis, Long> {
}
