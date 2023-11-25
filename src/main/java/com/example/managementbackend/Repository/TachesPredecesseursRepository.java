package com.example.managementbackend.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.managementbackend.model.Tache;
import com.example.managementbackend.model.TachesPredecesseurs;


@Repository
public interface TachesPredecesseursRepository extends JpaRepository<TachesPredecesseurs, Long> {
	/* tp.id, tp.tache_a_trav_id, tp.tache_p_trav_id */
	@Query(nativeQuery = true, value="select * from taches_predecesseurs tp where tp.tache_a_trav_id=?1")
    List<TachesPredecesseurs> findAllByTache_a_trav_id(Tache tache_a_trav_id);
	/* tp.id, tp.tache_a_trav_id, tp.tache_p_trav_id */
	@Query(nativeQuery = true, value="select * from taches_predecesseurs tp where tp.tache_a_trav_id=?1")
    List<TachesPredecesseurs> findAllByTache_a_trav_id2(Optional<Tache> tache_a_trav_id);
	/* tp.id, tp.tache_a_trav_id, tp.tache_p_trav_id */
	@Query(nativeQuery = true, value="select * from taches_predecesseurs tp where tp.tache_p_trav_id=?1")
	List<TachesPredecesseurs> findByTache_p_trav_id(Optional<Tache> tache_p_trav_id);
}
