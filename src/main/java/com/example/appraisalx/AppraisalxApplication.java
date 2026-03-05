package com.example.appraisalx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppraisalxApplication {
	public static void main(String[] args) {
		SpringApplication.run(AppraisalxApplication.class, args);
		System.out.println(" AppraisalX Backend is running at http://localhost:8080");
		System.out.println(" API Endpoints:");
		System.out.println("   GET  /api/appraisal/employee/{empId}  → Fetch employee for auto-fill");
		System.out.println("   POST /api/appraisal/submit             → Submit appraisal form");
		System.out.println("   GET  /api/appraisal/all                → View all appraisals (HR)");
		System.out.println("   GET  /api/appraisal/history/{empId}    → View employee appraisal history");
	}
}
