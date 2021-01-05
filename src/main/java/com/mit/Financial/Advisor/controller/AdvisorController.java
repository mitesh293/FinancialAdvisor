package com.mit.Financial.Advisor.controller;

import com.mit.Financial.Advisor.dto.CurrentPortfolio;
import com.mit.Financial.Advisor.dto.CurrentPortfolioDollar;
import com.mit.Financial.Advisor.dto.RecommendPortfolio;
import com.mit.Financial.Advisor.dto.ResponseWrapperPortfolio;
import com.mit.Financial.Advisor.model.RiskPortfolioPercentage;
import com.mit.Financial.Advisor.service.RiskPortfolioPercentageService;
import com.mit.Financial.Advisor.util.AdvisorUtility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class AdvisorController {

    @Autowired
    RiskPortfolioPercentageService riskPortfolioPercentageService;

    @GetMapping(value = "/getRecommendPortfolio/{riskScore}", produces = {"application/JSON"})
    public @ResponseBody ResponseEntity<List<RiskPortfolioPercentage>> getPortfolioPercentageByRiskScore(@PathVariable int riskScore){
        List<RiskPortfolioPercentage> recommendedPortfolioPercentage = riskPortfolioPercentageService.findByRiskScore(riskScore);
        if(recommendedPortfolioPercentage!=null && recommendedPortfolioPercentage.size()>0) {
            log.info("Logged getPortfolioPercentageByRiskScore() with result :: " + recommendedPortfolioPercentage.size());
            return ResponseEntity.ok()
                    .header("success","Your Recommended portfolio based on your risk preference :"+riskScore)
                    .body(recommendedPortfolioPercentage);

        }
        else
            return ResponseEntity.noContent().header("failed","no recommended portfolio found based on your risk preference :"+riskScore +" in our system").build();
    }

    @PostMapping(value = "/reBalancePortfolioAsPerRecommended",consumes = {"application/JSON"},produces = {"application/JSON"})
    public ResponseWrapperPortfolio adjustAsPerRecommendation(@RequestBody CurrentPortfolioDollar currentPortfolioDollar){
        CurrentPortfolio currentPortfolio = new CurrentPortfolio(currentPortfolioDollar);
        ResponseWrapperPortfolio responseWrapperPortfolio = new ResponseWrapperPortfolio();
        log.info("User defined Portfolio ::" +currentPortfolio +" in dollar");
        List<RiskPortfolioPercentage> recommendedPortfolioPercentage = riskPortfolioPercentageService.findByRiskScore(currentPortfolio.getRiskScore());
        if(recommendedPortfolioPercentage!=null && recommendedPortfolioPercentage.size()>0) {
            RiskPortfolioPercentage standardPercentage = recommendedPortfolioPercentage.get(0);
            AdvisorUtility.calculateRecommendPortfolio(standardPercentage,currentPortfolio,responseWrapperPortfolio);
        }
        return responseWrapperPortfolio;
    }
}
