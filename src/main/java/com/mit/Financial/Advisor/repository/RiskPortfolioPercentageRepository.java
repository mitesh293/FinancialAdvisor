package com.mit.Financial.Advisor.repository;

import com.mit.Financial.Advisor.model.RiskPortfolioPercentage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RiskPortfolioPercentageRepository extends CrudRepository<RiskPortfolioPercentage, Long> {
    List<RiskPortfolioPercentage> findByRiskScore(int riskLevel);
}
