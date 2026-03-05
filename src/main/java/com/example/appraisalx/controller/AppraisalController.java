package com.example.appraisalx.controller;

import com.example.appraisalx.entity.AppraisalEntity;
import com.example.appraisalx.model.AppraisalModel;
import com.example.appraisalx.model.EmployeeModel;
import com.example.appraisalx.service.AppraisalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/appraisal")
@CrossOrigin(origins = "*")
public class AppraisalController {

    @Autowired
    private AppraisalService appraisalService;

    // ── GET Employee Details for Auto-Fill ─────────────────────
    @GetMapping("/employee/{empId}")
    public ResponseEntity<?> getEmployee(@PathVariable String empId) {
        try {
            EmployeeModel employee = appraisalService.getEmployeeDetails(empId);
            return ResponseEntity.ok(employee);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(Map.of("error", e.getMessage()));
        }
    }

    // ── POST Submit Appraisal ───────────────────────────────────
    @PostMapping("/submit")
    public ResponseEntity<?> submitAppraisal(@RequestBody AppraisalModel model) {
        try {
            Map<String, Object> result = appraisalService.submitAppraisal(model);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(Map.of("error", e.getMessage()));
        }
    }

    // ── GET All Appraisals (HR View) ────────────────────────────
    @GetMapping("/all")
    public ResponseEntity<?> getAllAppraisals() {
        try {
            List<AppraisalEntity> list = appraisalService.getAllAppraisals();
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of("error", e.getMessage()));
        }
    }

    // ── GET Appraisal History by EMP ID ────────────────────────
    @GetMapping("/history/{empId}")
    public ResponseEntity<?> getHistory(@PathVariable String empId) {
        try {
            List<AppraisalEntity> list = appraisalService.getAllAppraisals()
                    .stream()
                    .filter(a -> a.getEmpId().equals(empId))
                    .toList();
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of("error", e.getMessage()));
        }
    }
}