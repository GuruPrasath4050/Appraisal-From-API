package com.example.appraisalx.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

// @Entity = "Hey Java, this class represents a MySQL table"
// @Table = "The MySQL table name is 'employees'"
@Entity
@Table(name = "employees")
public class EmployeeEntity {

    // @Id = this is the PRIMARY KEY
    // We use empId as PK (not auto-generated, HR sets it like EMP001)
    @Id
    @Column(name = "emp_id")
    private String empId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "dob")
    private LocalDate dob;

    @Column(name = "joining_date")
    private LocalDate joiningDate;

    @Column(name = "department")
    private String department;

    @Column(name = "designation")
    private String designation;

    // Getters and Setters (IntelliJ shortcut: Alt+Insert → Getters and Setters)
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

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }
}