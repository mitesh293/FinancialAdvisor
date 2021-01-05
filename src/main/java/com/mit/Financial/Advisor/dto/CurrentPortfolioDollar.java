package com.mit.Financial.Advisor.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class CurrentPortfolioDollar {
    private int riskScore;
    private String bonds;
    private String largeCap;
    private String midCap;
    private String foreignCap;
    private String smallCap;
}
