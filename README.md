# AI Resume Optimizer API

An AI-powered REST API that analyzes resumes against job descriptions and generates ATS-focused improvement suggestions using LLMs.

## Features

• Resume parsing from uploaded PDF files
• AI-powered resume analysis using Gemini API
• ATS keyword gap detection
• Resume–Job Description match scoring
• Structured JSON response for automated systems
• Analysis history stored in PostgreSQL

## Tech Stack

Backend: Java, Spring Boot
AI Integration: Spring AI, Gemini API
Database: PostgreSQL
PDF Processing: Apache PDFBox
Architecture: REST API, Layered Architecture

## API Endpoints

POST /api/resume/analyze
Content-Type: multipart/form-data

resume: resume.pdf
jobDescription: "Java Backend Developer with Spring Boot experience"


## Example Response

{
"matchScore": 82,
"missingKeywords": ["Docker","Kubernetes"],
"suggestions": [
"Add containerization experience",
"Highlight microservices architecture"
]
}

## Architecture

Controller → Service → Gemini API → DTO Parsing → Database Storage

#diagram
Client (Postman)
        ↓
ResumeController
        ↓
ResumeService
        ↓
PDF Parsing (PDFBox)
        ↓
Gemini AI Analysis
        ↓
DTO Parsing
        ↓
PostgreSQL Database



## Future Improvements

• Semantic resume matching using embeddings
• Resume rewriting suggestions
• Batch resume analysis for recruiters
