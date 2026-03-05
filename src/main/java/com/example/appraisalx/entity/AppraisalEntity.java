package com.example.appraisalx.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "appraisals")
public class AppraisalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "emp_id")
    private String empId;

    @Column(name = "emp_name")
    private String empName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address", columnDefinition = "TEXT")
    private String address;

    @Column(name = "dob")
    private String dob;

    @Column(name = "joining_date")
    private String joiningDate;

    @Column(name = "experience_years")
    private String experienceYears;

    @Column(name = "department")
    private String department;

    @Column(name = "designation")
    private String designation;

    @Column(name = "project_description", columnDefinition = "TEXT")
    private String projectDescription;

    @Column(name = "self_rating")
    private Integer selfRating;

    @Column(name = "collaboration_rating")
    private Integer collaborationRating;

    @Column(name = "work_experience_summary", columnDefinition = "TEXT")
    private String workExperienceSummary;

    @Column(name = "skills_learned", columnDefinition = "TEXT")
    private String skillsLearned;

    @Column(name = "role_importance", columnDefinition = "TEXT")
    private String roleImportance;

    @Column(name = "future_goals", columnDefinition = "TEXT")
    private String futureGoals;

    @Column(name = "submitted_at")
    private LocalDateTime submittedAt;

    @PrePersist
    public void prePersist() { this.submittedAt = LocalDateTime.now(); }

    // ── Getters & Setters ──────────────────────────────────────

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEmpId() { return empId; }
    public void setEmpId(String empId) { this.empId = empId; }

    public String getEmpName() { return empName; }
    public void setEmpName(String empName) { this.empName = empName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = dob; }

    public String getJoiningDate() { return joiningDate; }
    public void setJoiningDate(String joiningDate) { this.joiningDate = joiningDate; }

    public String getExperienceYears() { return experienceYears; }
    public void setExperienceYears(String experienceYears) { this.experienceYears = experienceYears; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }

    public String getProjectDescription() { return projectDescription; }
    public void setProjectDescription(String projectDescription) { this.projectDescription = projectDescription; }

    public Integer getSelfRating() { return selfRating; }
    public void setSelfRating(Integer selfRating) { this.selfRating = selfRating; }

    public Integer getCollaborationRating() { return collaborationRating; }
    public void setCollaborationRating(Integer collaborationRating) { this.collaborationRating = collaborationRating; }

    public String getWorkExperienceSummary() { return workExperienceSummary; }
    public void setWorkExperienceSummary(String workExperienceSummary) { this.workExperienceSummary = workExperienceSummary; }

    public String getSkillsLearned() { return skillsLearned; }
    public void setSkillsLearned(String skillsLearned) { this.skillsLearned = skillsLearned; }

    public String getRoleImportance() { return roleImportance; }
    public void setRoleImportance(String roleImportance) { this.roleImportance = roleImportance; }

    public String getFutureGoals() { return futureGoals; }
    public void setFutureGoals(String futureGoals) { this.futureGoals = futureGoals; }

    public LocalDateTime getSubmittedAt() { return submittedAt; }
    public void setSubmittedAt(LocalDateTime submittedAt) { this.submittedAt = submittedAt; }
}