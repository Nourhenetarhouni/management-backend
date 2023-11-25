package com.example.managementbackend.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.managementbackend.model.Tache;

@Repository
public interface TacheRepository extends JpaRepository<Tache, Long> {
    List<Tache> findByBondecommandeId(long bcId);
    Optional<Tache> findByIdAndBondecommandeId(long id, long bcId);
    Optional<Tache> findByCode(String code);
}
