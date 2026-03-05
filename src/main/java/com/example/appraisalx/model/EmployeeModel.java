package com.example.appraisalx.model;

import java.time.LocalDate;


public class EmployeeModel {

    private String empId;
    private String name;
    private String email;
    private String phone;
    private String address;
    private LocalDate dob;
    private LocalDate joiningDate;
    private String experienceYears;  // This is CALCULATED (not in DB), e.g. "2 years 3 months"
    private String department;
    private String designation;

    // Empty constructor (required by Spring/Jackson to convert to JSON)
    public EmployeeModel() {}

    // Full constructor (used in AppraisalService to build the response)
    public EmployeeModel(String empId, String name, String email, String phone,
                         String address, LocalDate dob, LocalDate joiningDate,
                         String experienceYears, String department, String designation) {
        this.empId = empId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.dob = dob;
        this.joiningDate = joiningDate;
        this.experienceYears = experienceYears;
        this.department = department;
        this.designation = designation;
    }

    // Getters and Setters
    public String getEmpId() { return empId; }
    public void setEmpId(String empId) { this.empId = empId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public LocalDate getDob() { return dob; }
    public void setDob(LocalDate dob) { this.dob = dob; }

    public LocalDate getJoiningDate() { return joiningDate; }
    public void setJoiningDate(LocalDate joiningDate) { this.joiningDate = joiningDate; }

    public String getExperienceYears() { return experienceYears; }
    public void setExperienceYears(String experienceYears) { this.experienceYears = experienceYears; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }
}
