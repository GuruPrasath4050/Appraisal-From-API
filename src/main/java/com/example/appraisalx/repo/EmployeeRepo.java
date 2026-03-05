package com.example.appraisalx.repo;

import com.example.appraisalx.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

// JpaRepository<EmployeeEntity, String> means:
//   → Work with EmployeeEntity table
//   → Primary key (empId) is of type String
//
// Just by extending JpaRepository, you get FREE methods like:
//   findAll(), save(), deleteById(), findById() etc.
//   NO SQL needed! Spring writes it for you.
@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeEntity, String> {

    // Spring reads this method name and auto-generates:
    // SELECT * FROM employees WHERE emp_id = ?
    Optional<EmployeeEntity> findByEmpId(String empId);

    // SELECT COUNT(*) FROM employees WHERE emp_id = ? → returns true/false
    boolean existsByEmpId(String empId);
}