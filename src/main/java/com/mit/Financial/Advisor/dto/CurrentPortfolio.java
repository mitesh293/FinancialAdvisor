package com.mit.Financial.Advisor.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Slf4j
public class CurrentPortfolio {
    private int riskScore;
    private int bonds;
    private int largeCap;
    private int midCap;
    private int foreignCap;
    private int smallCap;

    public CurrentPortfolio(CurrentPortfolioDollar currentPortfolioDollar){
        this.riskScore = currentPortfolioDollar.getRiskScore();
        this.bonds = Integer.parseInt(currentPortfolioDollar.getBonds().replace("$",""));
        this.largeCap = Integer.parseInt(currentPortfolioDollar.getLargeCap().replace("$",""));
        this.midCap = Integer.parseInt(currentPortfolioDollar.getMidCap().replace("$",""));
        this.foreignCap = Integer.parseInt(currentPortfolioDollar.getForeignCap().replace("$",""));
        this.smallCap = Integer.parseInt(currentPortfolioDollar.getSmallCap().replace("$",""));
        log.info(this.toString());
    }
    public int getSumOfCurrentPortfolio(){
        return bonds+largeCap+midCap+foreignCap+smallCap;
    }
}
