package com.example.managementbackend.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "taches_predecesseurs")
public class TachesPredecesseurs {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tache_a_trav_id")
    private Tache tache_a_trav_id;

    @ManyToOne
    @JoinColumn(name = "tache_p_trav_id")
    private Tache tache_p_trav_id;

	public TachesPredecesseurs(Long id, Tache tache_a_trav_id, Tache tache_p_trav_id) {
		super();
		this.id = id;
		this.tache_a_trav_id = tache_a_trav_id;
		this.tache_p_trav_id = tache_p_trav_id;
	}

	public TachesPredecesseurs() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tache getTache_a_trav_id() {
		return tache_a_trav_id;
	}

	public void setTache_a_trav_id(Tache tache_a_trav_id) {
		this.tache_a_trav_id = tache_a_trav_id;
	}

	public Tache getTache_p_trav_id() {
		return tache_p_trav_id;
	}

	public void setTache_p_trav_id(Tache tache_p_trav_id) {
		this.tache_p_trav_id = tache_p_trav_id;
	}

	public Long getId() {
		return id;
	}
}
