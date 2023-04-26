package com.afrimoov.afribelle.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class BaseSaleItemDto extends BaseItemDto {

    @JsonProperty("normal_price_formated")
    private String normalPriceStr;

    @JsonProperty("normal_price")
    private Double normalPrice;

    @JsonProperty("normal_price_currency")
    private String normalPriceCurrency;

    @JsonProperty("in_promotion")
    private Boolean inPromotion;

    @JsonProperty("promotion_price_formated")
    private String promotionPriceStr;

    @JsonProperty("promotion_price")
    private Double promotionPrice;

    @JsonProperty("promotion_price_currency")
    private String promotionPriceCurrency;

    @JsonProperty("fees_formated")
    private String feesStr;

    @JsonProperty("fees")
    private Double fees;

    @JsonProperty("fees_currency")
    private String feesCurrency;

    @JsonProperty("promotion_fees_formated")
    private String promotionFeesStr;

    @JsonProperty("promotion_fees")
    private Double promotionFees;

    @JsonProperty("promotion_fees_currency")
    private String promotiondFeesCurrency;

    @JsonProperty("payement_methods_str")
    private String paymentMethodsStr;

    @JsonProperty("payement_methods")
    private List<String> paymentMethods;

    @JsonProperty("date_debut_promo")
    private String dateDebutPromo;

    @JsonProperty("date_fin_promo")
    private String dateFinPromo;

    @JsonProperty("date_debut_promo_fees")
    private String dateDebutPromoFees;

    @JsonProperty("date_fin_promo_fees")
    private String dateFinPromoFees;
}
