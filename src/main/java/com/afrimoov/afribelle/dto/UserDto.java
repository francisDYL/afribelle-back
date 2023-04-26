package com.afrimoov.afribelle.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("notification_id")
    private String notificationId;


    @JsonProperty("firebase_id")
    private String firebaseId;

    // Un nom unique d'identification de l'utilisateur
    @JsonProperty("username")
    private String username;

    // The name of the user
    @JsonProperty("user_name")
    private String name;


    @JsonProperty("last_name")
    private String lastName;


    @JsonProperty("first_name")
    private String firstName;


    @JsonProperty("type_utilisateur")
    private String typeUtilisateur;


    @JsonProperty("date_creation")
    private String dateCreation;


    @JsonProperty("last_modification")
    private String lastModification;


    @JsonProperty("last_connexion")
    private String lastConnexion;


    @JsonProperty("langue")
    private String langue;


    @JsonProperty("device_country")
    private Long deviceCountry;


    @JsonProperty("location_country")
    private Long locationCountry;


    @JsonProperty("selected_country")
    private Long selectedCountry;


    @JsonProperty("ville")
    private Long ville;


    @JsonProperty("quartier")
    private Long quartier;


    @JsonProperty("adresse")
    private Long adresse;


    @JsonProperty("nb_services")
    private Long nbServices;


    @JsonProperty("nb_produits")
    private Long nbProduits;


    @JsonProperty("nb_commandes")
    private Long nbCommandes;


    @JsonProperty("nb_commandes_executees")
    private Long nbCommandesExecutees;


    @JsonProperty("nb_commandes_en_cours")
    private Long nbCommandesEnCours;


    @JsonProperty("nb_commandes_annules")
    private Long nbCommandesAnnules;


    @JsonProperty("total_ventes")
    private Long totalVentes;


    @JsonProperty("subscribers")
    private Long subscribers;


    @JsonProperty("views")
    private Long views;


    @JsonProperty("status")
    private String status;


    @JsonProperty("reports")
    private Long reports;


    @JsonProperty("biographie")
    private String biographie;


    @JsonProperty("phone")
    private String phone;


    @JsonProperty("whatsapp_number")
    private String whatsappNumber;


    @JsonProperty("site_web")
    private String siteWeb;


    @JsonProperty("nb_partages")
    private Long shares;


    @JsonProperty("nb_likes")
    private Long likes;


    @JsonProperty("nb_avis")
    private Long avis;


    @JsonProperty("moyenne_avis")
    private Double moyenneAvis;


    @JsonProperty("liked")
    private Boolean liked;


    @JsonProperty("photo_profil")
    private String photoProfil;
}
