package com.example.managementbackend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.managementbackend.Repository.BondeCommandeRepository;
import com.example.managementbackend.Repository.TacheRepository;
import com.example.managementbackend.exception.ResourceNotFoundException;
import com.example.managementbackend.model.Tache;

@Service
public class TacheService {
    @Autowired
    private TacheRepository tacheRepo;
    @Autowired
    private BondeCommandeRepository bondecommandeRepo;
    
    public List<Tache> getAllTachesByBcId(Long bcId) {
        return tacheRepo.findByBondecommandeId(bcId);
    }

    public Optional<Tache> getById(Long tcId) {
        return tacheRepo.findById(tcId);
    }
    public Tache changeTache(Tache tache) {
        return tacheRepo.save(tache);
    }

    public List<Tache> getAll() {
        return tacheRepo.findAll();
    }
    
    public Optional<Tache> getByCode(String code) {
    	return tacheRepo.findByCode(code).map(tache ->
    		tacheRepo.findByCode(code)
    	).orElseThrow(() -> new ResourceNotFoundException("codeTache" + code+ " not found"));
    }

    public Tache create(Long bcId, Tache tache) {
        return bondecommandeRepo.findById(bcId).map(bondecommande -> {
        	tache.setBondeCommande(bondecommande);
            System.out.println(tache.getDateDebutNewBC());
            return tacheRepo.save(tache);
        }).orElseThrow(() -> new ResourceNotFoundException("bcId " + bcId + " not found"));
    }


    public ResponseEntity<?> delete(Long bcId, Long tcId) {
        return  tacheRepo.findByIdAndBondecommandeId(tcId, bcId).map(tache -> {
        	tacheRepo.delete(tache);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("tache with id " + tcId+ " and tcId " + tcId));
    }
}
