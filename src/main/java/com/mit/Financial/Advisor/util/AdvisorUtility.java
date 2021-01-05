package com.mit.Financial.Advisor.util;

import com.mit.Financial.Advisor.dto.CurrentPortfolio;
import com.mit.Financial.Advisor.dto.CurrentPortfolioDollar;
import com.mit.Financial.Advisor.dto.RecommendPortfolio;
import com.mit.Financial.Advisor.dto.ResponseWrapperPortfolio;
import com.mit.Financial.Advisor.model.RiskPortfolioPercentage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AdvisorUtility {
    public static RecommendPortfolio calculateRecommendPortfolio(RiskPortfolioPercentage standardPercentage, CurrentPortfolio currentPortfolio, ResponseWrapperPortfolio responseWrapperPortfolio){
        RecommendPortfolio differencePortfolio = new RecommendPortfolio();
        RecommendPortfolio recommendPortfolio = new RecommendPortfolio();
        int totalCurrentPortfolioDollar = currentPortfolio.getSumOfCurrentPortfolio();
        log.info("In side calculateRecommendPortfolio :: "+totalCurrentPortfolioDollar);

        recommendPortfolio.setBonds(totalCurrentPortfolioDollar * standardPercentage.getBonds() / 100);
        recommendPortfolio.setForeignCap(totalCurrentPortfolioDollar * standardPercentage.getForeignCap() / 100);
        recommendPortfolio.setLargeCap(totalCurrentPortfolioDollar * standardPercentage.getLargeCap() / 100);
        recommendPortfolio.setMidCap(totalCurrentPortfolioDollar * standardPercentage.getMidCap() / 100);
        recommendPortfolio.setSmallCap(totalCurrentPortfolioDollar * standardPercentage.getSmallCap() / 100);
        log.info("New Recommend Portfolio :: "+recommendPortfolio);

        differencePortfolio.setBonds((totalCurrentPortfolioDollar * standardPercentage.getBonds() / 100) - currentPortfolio.getBonds());
        differencePortfolio.setForeignCap((totalCurrentPortfolioDollar * standardPercentage.getForeignCap() / 100) - currentPortfolio.getForeignCap());
        differencePortfolio.setLargeCap((totalCurrentPortfolioDollar * standardPercentage.getLargeCap() / 100) - currentPortfolio.getLargeCap());
        differencePortfolio.setMidCap((totalCurrentPortfolioDollar * standardPercentage.getMidCap() / 100) -currentPortfolio.getMidCap());
        differencePortfolio.setSmallCap((totalCurrentPortfolioDollar * standardPercentage.getSmallCap() / 100) - currentPortfolio.getSmallCap());

        //transfer rule engine.

        log.info("Difference in Portfolio :: "+differencePortfolio.toString());
        responseWrapperPortfolio.setDifferencePortfolio(differencePortfolio);
        responseWrapperPortfolio.setNewRecommendPortfolio(recommendPortfolio);
        responseWrapperPortfolio.setRecommendedTransfers(null);

        return recommendPortfolio;
    }
}
