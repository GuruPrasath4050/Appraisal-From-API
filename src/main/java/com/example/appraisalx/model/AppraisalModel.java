package com.example.appraisalx.model;

public class AppraisalModel {

    private String empId;
    private String projectDescription;
    private Integer selfRating;
    private Integer collaborationRating;
    private String workExperienceSummary;
    private String skillsLearned;
    private String roleImportance;
    private String futureGoals;

    public String getEmpId() { return empId; }
    public void setEmpId(String empId) { this.empId = empId; }

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
}