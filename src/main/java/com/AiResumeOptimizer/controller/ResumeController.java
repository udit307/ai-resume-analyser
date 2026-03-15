package com.AiResumeOptimizer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.AiResumeOptimizer.service.ResumeService;

@RestController
@RequestMapping("/api/resume")
public class ResumeController {

	@Autowired
    private final ResumeService resumeService;

    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @PostMapping("/analyze")
    public ResponseEntity<?> analyzeResume(
            @RequestParam("resume") MultipartFile file,
            @RequestParam("jobDescription") String jobDescription
    ) {

        return ResponseEntity.ok(
                resumeService.analyzeResume(file, jobDescription)
        );
    }
}