package com.afrimoov.afribelle.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.persistence.MappedSuperclass;
import java.util.List;

@Data
@MappedSuperclass
public class BaseSaleItem extends BaseItem {

    @Column(name = "normal_price_formated")
    protected String normalPriceStr;

    @Column(name = "normal_price")
    protected Double normalPrice;

    @Column(name = "normal_price_currency")
    protected String normalPriceCurrency;

    @Column(name = "in_promotion")
    protected Boolean inPromotion;

    @Column(name = "promotion_price_formated")
    protected String promotionPriceStr;

    @Column(name = "promotion_price")
    protected Double promotionPrice;

    @Column(name = "promotion_price_currency")
    protected String promotionPriceCurrency;

    @Column(name = "fees_formated")
    protected String feesStr;

    @Column(name = "fees")
    protected Double fees;

    @Column(name = "fees_currency")
    protected String feesCurrency;

    @Column(name = "promotion_fees_formated")
    protected String promotionFeesStr;

    @Column(name = "promotion_fees")
    protected Double promotionFees;

    @Column(name = "promotion_fees_currency")
    protected String promotiondFeesCurrency;

    @Column(name = "payement_methods_str")
    protected String paymentMethodsStr;

    @Column(name = "payement_methods")
    @ElementCollection(targetClass = String.class, fetch = FetchType.LAZY)
    protected List<String> paymentMethods;

    @Column(name = "date_debut_promo")
    protected String dateDebutPromo;

    @Column(name = "date_fin_promo")
    protected String dateFinPromo;

    @Column(name = "date_debut_promo_fees")
    protected String dateDebutPromoFees;

    @Column(name = "date_fin_promo_fees")
    protected String dateFinPromoFees;
}
