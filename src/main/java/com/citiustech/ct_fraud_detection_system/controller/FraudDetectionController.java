package com.citiustech.ct_fraud_detection_system.controller;

import com.citiustech.ct_fraud_detection_system.model.FraudAlert;
import com.citiustech.ct_fraud_detection_system.service.FraudDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/fraud")
public class FraudDetectionController {

    @Autowired
    private FraudDetectionService fraudDetectionService;

    // API to analyze claim for fraud
    @PostMapping("/analyze")
    public String analyzeClaim(@RequestParam("claimId") String claimId, @RequestParam("providerId") String providerId, Model model) {
        FraudAlert fraudAlert = fraudDetectionService.analyzeClaimForFraud(claimId, providerId);
        model.addAttribute("fraudAlert", fraudAlert);
        return "fraud-analysis-result";
    }

    // API to display the fraud alert dashboard
    @GetMapping("/dashboard")
    public String fraudAlertDashboard(Model model) {
        System.out.println("request received");
        List<FraudAlert> fraudAlerts = fraudDetectionService.getAllFraudAlerts();
        model.addAttribute("fraudAlerts", fraudAlerts);
        return "fraud-alert-dashboard";
    }
}

