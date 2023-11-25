package com.example.managementbackend.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TacheArticleAssocId implements Serializable {
    @Column(name = "tache_id")
    private Long tache_id;

    @Column(name = "article_id")
    private Long article_id;

    public TacheArticleAssocId(Long tache_id, Long article_id) {
        this.tache_id = tache_id;
        this.article_id = article_id;
    }

    public TacheArticleAssocId() {}

	public Long getTache_id() {
		return tache_id;
	}

	public void setTache_id(Long tache_id) {
		this.tache_id = tache_id;
	}

	public Long getArticle_id() {
		return article_id;
	}

	public void setArticle_id(Long article_id) {
		this.article_id = article_id;
	}
    

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TacheArticleAssocId)) return false;
        TacheArticleAssocId that = (TacheArticleAssocId) o;
        return tache_id.equals(that.tache_id) && article_id.equals(that.article_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tache_id, article_id);
    }
}
