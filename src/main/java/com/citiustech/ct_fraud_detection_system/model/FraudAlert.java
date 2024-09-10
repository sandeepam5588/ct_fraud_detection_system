package com.citiustech.ct_fraud_detection_system.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "fraud_alert")
public class FraudAlert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alert_id")
    private int alertId;

    @Column(name = "claim_id", nullable = false)
    private String claimId;

    @Column(name = "provider_id", nullable = false)
    private String providerId;

    @Column(name = "alert_level", nullable = false)
    private String alertLevel;

    @Column(name = "alert_reason")
    private String alertReason;

    @Column(name = "alert_action_taken")
    private String alertActionTaken;

    @Column(name = "alert_reported_date")
    private LocalDateTime alertReportedDate;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
}
