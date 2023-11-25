package com.example.managementbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import javax.persistence.*;

@Entity
@Table(name = "tachearticleassoc")
public class TacheArticleAssoc {
    @EmbeddedId
    private TacheArticleAssocId id;

    @JsonIgnore
    @ManyToOne
    @MapsId("tache_id")
    @JoinColumn(name = "tache_id")
    private Tache tache;

    @JsonIgnore
    @ManyToOne
    @MapsId("article_id")
    @JoinColumn(name = "article_id")
    private Article article;

    @NotNull
    private float prix;
    @NotNull
    private long quantitee;
   
	public TacheArticleAssoc(Tache tache, Article article, float prix, long quantitee) {
        this.id = new TacheArticleAssocId(tache.getId(), article.getId());
        
		this.tache = tache;
		this.article = article;
		this.prix = prix;
		this.quantitee = quantitee;
	}
	

	public TacheArticleAssoc() {}


	public TacheArticleAssocId getId() {
		return id;
	}


	public void setId(TacheArticleAssocId id) {
		this.id = id;
	}


	public Tache getTache() {
		return tache;
	}


	public void setTache(Tache tache) {
		this.tache = tache;
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

