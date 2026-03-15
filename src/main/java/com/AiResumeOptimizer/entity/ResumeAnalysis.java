package com.AiResumeOptimizer.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResumeAnalysis {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private int matchScore;

	    @Column(columnDefinition = "TEXT")
	    private String missingKeywords;

	    @Column(columnDefinition = "TEXT")
	    private String suggestions;

	    private LocalDateTime createdAt;

	    public ResumeAnalysis(int matchScore, String missingKeywords, String suggestions) {
	        this.matchScore = matchScore;
	        this.missingKeywords = missingKeywords;
	        this.suggestions = suggestions;
	        this.createdAt = LocalDateTime.now();
	    }

	    
	}
