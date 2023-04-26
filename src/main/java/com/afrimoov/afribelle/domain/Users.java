package com.afrimoov.afribelle.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_user")
public class Users extends DomainTimeStamp {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "notification_id")
    private String notificationId;

    @Column(name = "firebase_id")
    private String firebaseId;
    // Un nom unique d'identification de l'utilisateur

    @Column(name = "user_ame")
    private String username;
    // The name of the user

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "type_utilisateur")
    private String typeUtilisateur;

    @Column(name = "date_creation")
    private String dateCreation;

    @Column(name = "last_modification")
    private String lastModification;

    @Column(name = "last_connexion")
    private String lastConnexion;

    @Column(name = "langue")
    private String langue;

    @Column(name = "device_country")
    private Long deviceCountry;

    @Column(name = "location_country")
    private Long locationCountry;

    @Column(name = "selected_country")
    private Long selectedCountry;

    @Column(name = "ville")
    private Long ville;

    @Column(name = "quartier")
    private Long quartier;

    @Column(name = "adresse")
    private Long adresse;

    @Column(name = "nb_services")
    private Long nbServices;

    @Column(name = "nb_produits")
    private Long nbProduits;

    @Column(name = "nb_commandes")
    private Long nbCommandes;

    @Column(name = "nb_commandes_executees")
    private Long nbCommandesExecutees;

    @Column(name = "nb_commandes_en_cours")
    private Long nbCommandesEnCours;

    @Column(name = "nb_commandes_annules")
    private Long nbCommandesAnnules;

    @Column(name = "total_ventes")
    private Long totalVentes;

    @Column(name = "subscribers")
    private Long subscribers;

    @Column(name = "views")
    private Long views;

    @Column(name = "status")
    private String status;

    @Column(name = "reports")
    private Long reports;

    @Column(name = "biographie")
    private String biographie;

    @Column(name = "phone")
    private String phone;

    @Column(name = "whatsapp_number")
    private String whatsappNumber;

    @Column(name = "site_web")
    private String siteWeb;

    @Column(name = "nb_partages")
    private Long shares;

    @Column(name = "nb_likes")
    private Long likes;

    @Column(name = "nb_avis")
    private Long avis;

    @Column(name = "moyenne_avis")
    private Double moyenneAvis;

    @Column(name = "liked")
    private Boolean liked;

    @Column(name = "photo_profil")
    private String photoProfil;
}
