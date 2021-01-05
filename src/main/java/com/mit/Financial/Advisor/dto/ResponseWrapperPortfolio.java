package com.mit.Financial.Advisor.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ResponseWrapperPortfolio {
    private RecommendPortfolio newRecommendPortfolio;
    private RecommendPortfolio differencePortfolio;
    private List<String> recommendedTransfers;
}
