package com.example.managementbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "organisation")

public class Organisation {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotNull
        @Column(unique = true)
        private String nom;

        @NotNull
        @Column(unique = true)
        private String code;

        @NotNull
        private String secteur_d_activite;

        @NotNull
        private String email;

        @NotNull
        private String pays;

        @NotNull
        private String region;

        @NotNull
        private String adresse;

        @NotNull
        private long tel;

        @NotNull
        private String type;


        @NotNull
        private String nomDG;


        @NotNull
        private long telDG;


        @NotNull
        private String emailDG;

        @NotNull
        private String nomAdmin;


        @NotNull
        private long telAdmin;


        @NotNull private String emailAdmin;


     /*   @OneToMany(cascade = CascadeType.ALL,
                fetch = FetchType.LAZY,
                mappedBy = "suporgan")
        private List<Organisation> entreprises = new ArrayList<>();

        @JsonIgnore
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "suporgan_id", nullable = true)
        private Organisation suporgan;
        */


        @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
        @OneToMany(cascade = CascadeType.ALL,
                fetch = FetchType.LAZY,
                mappedBy = "org")
        private List<Marchee> marchees = new ArrayList<>();

        // Getters and Setters (Omitted for brevity)


        public Organisation(String nom, String code, String secteur_d_activite, String email, String pays, String region, String adresse, long tel, String type, String nomDG, long telDG, String emailDG, String nomAdmin, long telAdmin, String emailAdmin, List<Marchee> marchees) {
                this.nom = nom;
                this.code = code;
                this.secteur_d_activite = secteur_d_activite;
                this.email = email;
                this.pays = pays;
                this.region = region;
                this.adresse = adresse;
                this.tel = tel;
                this.type = type;
                this.nomDG = nomDG;
                this.telDG = telDG;
                this.emailDG = emailDG;
                this.nomAdmin = nomAdmin;
                this.telAdmin = telAdmin;
                this.emailAdmin = emailAdmin;
                this.marchees = marchees;
        }

        public Organisation() {

        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getNom() {
                return nom;
        }

        public void setNom(String nom) {
                this.nom = nom;
        }

        public String getCode() {
                return code;
        }

        public void setCode(String code) {
                this.code = code;
        }

        public String getSecteur_d_activite() {
                return secteur_d_activite;
        }

        public void setSecteur_d_activite(String secteur_d_activite) {
                this.secteur_d_activite = secteur_d_activite;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getPays() {
                return pays;
        }

        public void setPays(String pays) {
                this.pays = pays;
        }

        public String getRegion() {
                return region;
        }

        public void setRegion(String region) {
                this.region = region;
        }

        public String getAdresse() {
                return adresse;
        }

        public void setAdresse(String adresse) {
                this.adresse = adresse;
        }

        public long getTel() {
                return tel;
        }

        public void setTel(long tel) {
                this.tel = tel;
        }

        public String getType() {
                return type;
        }

        public void setType(String type) {
                this.type = type;
        }

        public String getNomDG() {
                return nomDG;
        }

        public void setNomDG(String nomDG) {
                this.nomDG = nomDG;
        }

        public long getTelDG() {
                return telDG;
        }

        public void setTelDG(long telDG) {
                this.telDG = telDG;
        }

        public String getEmailDG() {
                return emailDG;
        }

        public void setEmailDG(String emailDG) {
                this.emailDG = emailDG;
        }

        public List<Marchee> getMarchees() {
                return marchees;
        }

        public void setMarchees(List<Marchee> marchees) {
                this.marchees = marchees;
        }

        public String getNomAdmin() {
                return nomAdmin;
        }

        public void setNomAdmin(String nomAdmin) {
                this.nomAdmin = nomAdmin;
        }

        public long getTelAdmin() {
                return telAdmin;
        }

        public void setTelAdmin(long telAdmin) {
                this.telAdmin = telAdmin;
        }

        public String getEmailAdmin() {
                return emailAdmin;
        }

        public void setEmailAdmin(String emailAdmin) {
                this.emailAdmin = emailAdmin;
        }
}

