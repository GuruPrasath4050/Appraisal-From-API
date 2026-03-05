package com.example.appraisalx.repo;

import com.example.appraisalx.entity.AppraisalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppraisalRepo extends JpaRepository<AppraisalEntity, Long> {

    /**
     * Get all appraisals submitted by a specific employee
     */
    List<AppraisalEntity> findByEmpId(String empId);

    /**
     * Check if employee has already submitted appraisal
     */
    boolean existsByEmpId(String empId);

    /**
     * Get latest appraisal for an employee
     */
    Optional<AppraisalEntity> findTopByEmpIdOrderBySubmittedAtDesc(String empId);
}
