package com.mit.Financial.Advisor.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class RecommendPortfolio {
    private int bonds;
    private int largeCap;
    private int midCap;
    private int foreignCap;
    private int smallCap;
}
