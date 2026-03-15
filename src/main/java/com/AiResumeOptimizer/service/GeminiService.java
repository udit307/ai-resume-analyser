package com.AiResumeOptimizer.service;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import com.AiResumeOptimizer.dto.ResumeAnalysisResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class GeminiService {

    private final ChatClient chatClient;

    public GeminiService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public ResumeAnalysisResponse analyze(String resumeText, String jobDescription) {

        String prompt = """
        You are an ATS resume analyzer.

        Job Description:
        %s

        Resume:
        %s

        Return response in JSON format:

        {
          "matchScore": number,
          "missingKeywords": [],
          "suggestions": []
        }
        """.formatted(jobDescription, resumeText);

        String response= chatClient.prompt()
                .user(prompt)
                .call()
                .content();
        
        System.out.println("@@@@@@@@@"+response+"@@@@@@@@@@@@");
        
        response = response.replace("```json", "")
                .replace("```", "")
                .trim();
        
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(response, ResumeAnalysisResponse.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse Gemini response", e);
        }
    }
}