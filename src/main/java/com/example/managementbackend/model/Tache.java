package com.example.managementbackend.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
@Table(name = "tache")
public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String code;
    
    @NotNull
    private String nom;

    @NotNull
    private Float delais;

    @NotNull
    private Float avancement;

    @NotNull
    private String dateDebutNewBC;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "bondecommande_id", nullable = false)
    private BondeCommande bondecommande;
    
    @OneToMany(mappedBy = "tache")
    private List<TacheArticleAssoc> tachearticlesassociation = new ArrayList<TacheArticleAssoc>();
    
    @OneToMany(mappedBy = "tache")
    private List<TacheArticleAssoc> tachepredecassoc = new ArrayList<TacheArticleAssoc>();

	public Tache(String code, String nom, Float delais, String dateDebutNewBC, BondeCommande bondecommande, List<TacheArticleAssoc> tachepredecassoc, List<TacheArticleAssoc> tachearticlesassociation) {
		super();
		this.code = code;
		this.nom = nom;
		this.delais = delais;
        this.dateDebutNewBC = dateDebutNewBC;
		this.bondecommande = bondecommande;
		this.tachearticlesassociation = tachearticlesassociation;
		this.tachepredecassoc = tachepredecassoc;
	}

	public Tache() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Float getDelais() {
		return delais;
	}

	public void setDelais(Float delais) {
		this.delais = delais;
	}

	public String getDateDebutNewBC() {
		return dateDebutNewBC;
	}

	public void setDateDebutNewBC(String dateDebutNewBC) {
		this.dateDebutNewBC = dateDebutNewBC;
	}

	public BondeCommande getBondeCommande() {
		return bondecommande;
	}

	public void setBondeCommande(BondeCommande bondecommande) {
		this.bondecommande = bondecommande;
	}

	public List<TacheArticleAssoc> getArticlesassociation() {
		return tachearticlesassociation;
	}

	public void setArticlesassociation(List<TacheArticleAssoc> tachearticlesassociation) {
		this.tachearticlesassociation = tachearticlesassociation;
	}

	public List<TacheArticleAssoc> getTachesPreced() {
		return tachepredecassoc;
	}

	public void setTachesPreced(List<TacheArticleAssoc> tachepredecassoc) {
		this.tachepredecassoc = tachepredecassoc;
	}

	public Float getAvancement() {
		return avancement;
	}

	public void setAvancement(Float avancement) {
		this.avancement = avancement;
	}
	
}
