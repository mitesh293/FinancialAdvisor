package com.mit.Financial.Advisor.service;

import com.mit.Financial.Advisor.model.RiskPortfolioPercentage;
import com.mit.Financial.Advisor.repository.RiskPortfolioPercentageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RiskPortfolioPercentageService {
    @Autowired
    RiskPortfolioPercentageRepository riskPortfolioPercentageRepository;

    public List<RiskPortfolioPercentage> findByRiskScore(int riskLevel){
        log.info("called findByRiskScore::"+riskLevel);
        return riskPortfolioPercentageRepository.findByRiskScore(riskLevel);
    }
}
