package com.example.managementbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "articleutilisee")
public class ArticleUtilisee {
    @EmbeddedId
    private AticleUtiliseeId id;

    @JsonIgnore
    @ManyToOne
    @MapsId("bondecommande_id") //This is the name of attr in EmployerDeliveryAgentPK class
    @JoinColumn(name = "bondecommande_id")
    private BondeCommande bondecommande;

    @JsonIgnore
    @ManyToOne
    @MapsId("article_id")
    @JoinColumn(name = "article_id")
    private Article article;

    @NotNull
    private float prix;


    @NotNull
    private long quantitee;
   /* @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bc_id", nullable = false)
    private BondeCommande bondecommande;
    */


    public ArticleUtilisee(BondeCommande bondecommande, Article article, float prix, long quantitee) {
        // create primary key
        this.id = new AticleUtiliseeId(bondecommande.getId(), article.getId());

        // initialize attributes
        this.bondecommande = bondecommande;
        this.article = article;
        this.prix = prix;
        this.quantitee = quantitee;
    }

    public ArticleUtilisee() {

    }


    public AticleUtiliseeId getId() {
        return id;
    }

    public void setId(AticleUtiliseeId id) {
        this.id = id;
    }

    public BondeCommande getBondecommande() {
        return bondecommande;
    }

    public void setBondecommande(BondeCommande bondecommande) {
        this.bondecommande = bondecommande;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public long getQuantitee() {
        return quantitee;
    }

    public void setQuantitee(long quantitee) {
        this.quantitee = quantitee;
    }


}
