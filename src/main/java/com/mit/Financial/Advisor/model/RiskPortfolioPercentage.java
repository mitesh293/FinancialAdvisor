package com.mit.Financial.Advisor.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "risk_level_invt_portfolio_percentage")
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class RiskPortfolioPercentage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "risk_tolerance_score")
    private int riskScore;

    @NotBlank
    private int bonds;

    @NotBlank
    private int largeCap;

    @NotBlank
    private int midCap;

    @NotBlank
    private int foreignCap;

    @NotBlank
    private int smallCap;
}
