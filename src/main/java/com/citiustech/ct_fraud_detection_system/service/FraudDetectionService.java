package com.citiustech.ct_fraud_detection_system.service;

import com.citiustech.ct_fraud_detection_system.model.FraudAlert;
import com.citiustech.ct_fraud_detection_system.repository.FraudAlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FraudDetectionService {

    @Autowired
    private FraudAlertRepository fraudAlertRepository;

    // Logic to analyze a claim for fraud
    public FraudAlert analyzeClaimForFraud(String claimId, String providerId) {
        FraudAlert fraudAlert = new FraudAlert();
        fraudAlert.setClaimId(claimId);
        fraudAlert.setProviderId(providerId);

        // Apply fraud detection logic
        double fraudScore = Math.random(); // Simplified: Use proper algorithms

        if (fraudScore > 0.8) {
            fraudAlert.setAlertLevel("HIGH");
            fraudAlert.setAlertReason("Suspicious claim amount");
        } else if (fraudScore > 0.5) {
            fraudAlert.setAlertLevel("MEDIUM");
            fraudAlert.setAlertReason("Claim needs review");
        } else {
            fraudAlert.setAlertLevel("LOW");
            fraudAlert.setAlertReason("Minor discrepancies");
        }
        fraudAlert.setAlertActionTaken("Under investigation");
        fraudAlert.setAlertReportedDate(LocalDateTime.now());
        fraudAlert.setLastUpdate(LocalDateTime.now());

        // Save fraud alert to DB
        return fraudAlertRepository.save(fraudAlert);
    }

    // Retrieve all fraud alerts
    public List<FraudAlert> getAllFraudAlerts() {
        return fraudAlertRepository.findAll();
    }
}
