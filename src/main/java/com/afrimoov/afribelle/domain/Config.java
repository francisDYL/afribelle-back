package com.afrimoov.afribelle.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_config")
public class Config extends DomainTimeStamp {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="token")
    private String token;

    @Column(name ="token_expires_in")
    private Long tokenExpiresIn;
    // PUBLICITES

    @Column(name ="display_ads")
    private Boolean displayAds;

    @Column(name ="display_banner_ads")
    private Boolean displayBannerAds;

    @Column(name ="display_interstitial_ads")
    private Boolean displayInterstitialAds;

    @Column(name ="display_opened_ads")
    private Boolean displayOpenedAds;

    @Column(name ="display_reward_ads")
    private Boolean displayRewardAds;

    @Column(name ="display_native_ads")
    private Boolean displayNativeAds;

    @Column(name ="display_interstitial_images")
    private Boolean displayInterstitialImages;

    @Column(name ="display_interstitial_videos")
    private Boolean displayInterstitialVideos;

    @Column(name ="display_open_popup_ad")
    private Boolean displayOpenPopupAd;

    @Column(name ="nb_max_interstitial_ads_display_by_session")
    private Integer nbMaxInterstitialAdsDisplayBySession;

    @Column(name ="nb_max_reward_ads_display_by_session")
    private Integer nbMaxRewardAdsDisplayBySession;

    @Column(name ="nb_events_before_display_interstitial_ad")
    private Integer nbEventsBeforeDisplayInterstitialAd;

    @Column(name ="nb_events_before_display_reward_ad")
    private Integer nbEventsBeforeDisplayRewardAd;

    @Column(name ="nb_events_before_display_native_ad")
    private Integer nbEventsBeforeDisplayNativeAd;

    @Column(name ="interval_min_in_sec_before_display_interstitial_ad")
    private Integer intervalMinInSecBeforeDisplayInterstitialAd;

    @Column(name ="interval_min_in_sec_before_display_reward_ad")
    private Integer intervalMinInSecBeforeDisplayRewardAd;

    @Column(name ="nb_sessions_before_display_opened_ad")
    private Integer nbSessionsBeforeDisplayOpenedAd;

    // SERVICES
    @Column(name ="commentaires_max_length")
    private Integer commentairesMaxLength;

    @Column(name ="send_events_interval_in_sec")
    private Integer sendEventsIntervalInSec;
}
