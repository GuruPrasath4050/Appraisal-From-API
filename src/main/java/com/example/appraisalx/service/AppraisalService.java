package com.example.appraisalx.service;

import com.example.appraisalx.entity.AppraisalEntity;
import com.example.appraisalx.entity.EmployeeEntity;
import com.example.appraisalx.model.AppraisalModel;
import com.example.appraisalx.model.EmployeeModel;
import com.example.appraisalx.repo.AppraisalRepo;
import com.example.appraisalx.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppraisalService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private AppraisalRepo appraisalRepo;

    // ── Get Employee Details for Auto-Fill ─────────────────────
    public EmployeeModel getEmployeeDetails(String empId) {
        EmployeeEntity emp = employeeRepo.findByEmpId(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + empId));

        EmployeeModel model = new EmployeeModel();
        model.setEmpId(emp.getEmpId());
        model.setName(emp.getName());
        model.setEmail(emp.getEmail());
        model.setPhone(emp.getPhone());
        model.setAddress(emp.getAddress());
        model.setDob(LocalDate.parse(emp.getDob() != null ? emp.getDob().toString() : ""));
        model.setJoiningDate(LocalDate.parse(emp.getJoiningDate() != null ? emp.getJoiningDate().toString() : ""));
        model.setDepartment(emp.getDepartment());
        model.setDesignation(emp.getDesignation());
        model.setExperienceYears(calculateExperience(emp.getJoiningDate()));

        return model;
    }

    // ── Submit Appraisal ────────────────────────────────────────
    public Map<String, Object> submitAppraisal(AppraisalModel model) {
        EmployeeEntity emp = employeeRepo.findByEmpId(model.getEmpId())
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + model.getEmpId()));

        AppraisalEntity appraisal = new AppraisalEntity();

        // Auto-filled from DB
        appraisal.setEmpId(emp.getEmpId());
        appraisal.setEmpName(emp.getName());
        appraisal.setEmail(emp.getEmail());
        appraisal.setPhone(emp.getPhone());
        appraisal.setAddress(emp.getAddress());
        appraisal.setDob(emp.getDob() != null ? emp.getDob().toString() : "");
        appraisal.setJoiningDate(emp.getJoiningDate() != null ? emp.getJoiningDate().toString() : "");
        appraisal.setExperienceYears(calculateExperience(emp.getJoiningDate()));
        appraisal.setDepartment(emp.getDepartment());
        appraisal.setDesignation(emp.getDesignation());

        // Filled by employee
        appraisal.setProjectDescription(model.getProjectDescription());
        appraisal.setSelfRating(model.getSelfRating());
        appraisal.setCollaborationRating(model.getCollaborationRating());
        appraisal.setWorkExperienceSummary(model.getWorkExperienceSummary());
        appraisal.setSkillsLearned(model.getSkillsLearned());
        appraisal.setRoleImportance(model.getRoleImportance());
        appraisal.setFutureGoals(model.getFutureGoals());

        AppraisalEntity saved = appraisalRepo.save(appraisal);

        Map<String, Object> response = new HashMap<>();
        response.put("appraisalId", saved.getId());
        response.put("message", "Appraisal submitted successfully");
        response.put("employeeName", emp.getName());
        return response;
    }

    // ── Get All Appraisals (HR View) ────────────────────────────
    public List<AppraisalEntity> getAllAppraisals() {
        return appraisalRepo.findAll();
    }

    // ── Calculate Experience from Joining Date ──────────────────
    private String calculateExperience(LocalDate joiningDate) {
        if (joiningDate == null) return "N/A";
        Period period = Period.between(joiningDate, LocalDate.now());
        int years  = period.getYears();
        int months = period.getMonths();

        if (years == 0 && months == 0) return "Less than a month";
        if (years == 0) return months + (months == 1 ? " month" : " months");
        if (months == 0) return years + (years == 1 ? " year" : " years");
        return years + (years == 1 ? " year " : " years ") + months + (months == 1 ? " month" : " months");
    }
}