package com.afrimoov.afribelle.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ConfigDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("token")
    private String token;

    @JsonProperty("token_expires_in")
    private Long tokenExpiresIn;
    // PUBLICITES

    @JsonProperty("display_ads")
    private Boolean displayAds;

    @JsonProperty("display_banner_ads")
    private Boolean displayBannerAds;

    @JsonProperty("display_interstitial_ads")
    private Boolean displayInterstitialAds;

    @JsonProperty("display_opened_ads")
    private Boolean displayOpenedAds;

    @JsonProperty("display_reward_ads")
    private Boolean displayRewardAds;

    @JsonProperty("display_native_ads")
    private Boolean displayNativeAds;

    @JsonProperty("display_interstitial_images")
    private Boolean displayInterstitialImages;

    @JsonProperty("display_interstitial_videos")
    private Boolean displayInterstitialVideos;

    @JsonProperty("display_open_popup_ad")
    private Boolean displayOpenPopupAd;

    @JsonProperty("nb_max_interstitial_ads_display_by_session")
    private Integer nbMaxInterstitialAdsDisplayBySession;

    @JsonProperty("nb_max_reward_ads_display_by_session")
    private Integer nbMaxRewardAdsDisplayBySession;

    @JsonProperty("nb_events_before_display_interstitial_ad")
    private Integer nbEventsBeforeDisplayInterstitialAd;

    @JsonProperty("nb_events_before_display_reward_ad")
    private Integer nbEventsBeforeDisplayRewardAd;

    @JsonProperty("nb_events_before_display_native_ad")
    private Integer nbEventsBeforeDisplayNativeAd;

    @JsonProperty("interval_min_in_sec_before_display_interstitial_ad")
    private Integer intervalMinInSecBeforeDisplayInterstitialAd;

    @JsonProperty("interval_min_in_sec_before_display_reward_ad")
    private Integer intervalMinInSecBeforeDisplayRewardAd;

    @JsonProperty("nb_sessions_before_display_opened_ad")
    private Integer nbSessionsBeforeDisplayOpenedAd;

    // SERVICES
    @JsonProperty("commentaires_max_length")
    private Integer commentairesMaxLength;

    @JsonProperty("send_events_interval_in_sec")
    private Integer sendEventsIntervalInSec;
}
