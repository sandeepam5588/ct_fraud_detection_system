package com.citiustech.ct_fraud_detection_system.repository;

import com.citiustech.ct_fraud_detection_system.model.FraudAlert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FraudAlertRepository extends JpaRepository<FraudAlert, Integer> {

    List<FraudAlert> findByAlertLevel(String alertLevel);

    List<FraudAlert> findAll();
}
