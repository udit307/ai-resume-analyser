package com.AiResumeOptimizer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.AiResumeOptimizer.dto.ResumeAnalysisResponse;
import com.AiResumeOptimizer.entity.ResumeAnalysis;
import com.AiResumeOptimizer.repo.ResumeRepository;
import com.AiResumeOptimizer.util.PdfExtractor;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;




@RequiredArgsConstructor
@Service
public class ResumeService {

	
	@Autowired
	private final GeminiService geminiService;
	
	private final ResumeRepository repository;

//	    public ResumeService(GeminiService geminiService) {
//	        this.geminiService = geminiService;
//	    }

	    public ResumeAnalysisResponse analyzeResume(MultipartFile file, String jobDescription) {

	        try {

	            String resumeText = PdfExtractor.extractText(file);
	            
	            ResumeAnalysisResponse response=geminiService.analyze(resumeText, jobDescription);
	            
	            
	            
	            ResumeAnalysis entity = new ResumeAnalysis(
	                    response.getMatchScore(),
	                    response.getMissingKeywords().toString(),
	                    response.getSuggestions().toString()
	            );

	            repository.save(entity);

	            return response;

	        } catch (Exception e) {
	            throw new RuntimeException("Resume processing failed"+ e);
	        }
	    }

}
