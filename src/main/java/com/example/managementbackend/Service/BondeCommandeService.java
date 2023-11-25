package com.example.managementbackend.Service;

import com.example.managementbackend.Repository.BondeCommandeRepository;
import com.example.managementbackend.Repository.MarcheeRepository;
import com.example.managementbackend.Repository.OrganisationRepository;
import com.example.managementbackend.exception.ResourceNotFoundException;
import com.example.managementbackend.model.BondeCommande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
@Service
public class BondeCommandeService {
    @Autowired
    private BondeCommandeRepository bcRepo;

    @Autowired
    private MarcheeRepository marcheeRepo;

    @Autowired
    private OrganisationRepository organisationRepo;


    public List<BondeCommande> getAllbcsBymarcheeId(Long marcheeId) {
        return bcRepo.findByMarcheeId(marcheeId);
    }
    
    public Optional<BondeCommande> getById(long id){
    	return this.bcRepo.findById(id);
    }

    public List<BondeCommande> getAll() {
        return bcRepo.findAll();
    }

    public BondeCommande create(Long marcheeId,Long orgId, BondeCommande bondecommande) {
        return marcheeRepo.findById(marcheeId).map(marchee -> {
            bondecommande.setMarchee(marchee);
            return organisationRepo.findById(orgId).map(organisation -> {
                bondecommande.setOrganisation(organisation);
                return bcRepo.save(bondecommande);
            }).orElseThrow(() -> new ResourceNotFoundException("orgId " + orgId + " not found"));


        }).orElseThrow(() -> new ResourceNotFoundException("marcheeId " + marcheeId + " not found"));
    }


    public ResponseEntity<?> delete(Long marcheeId, Long bcId) {
        return  bcRepo.findByIdAndMarcheeId(bcId, marcheeId).map(bondecommande -> {
            bcRepo.delete(bondecommande);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("bonde commande not found with id " + bcId+ " and marcheeId " + marcheeId));
    }
}
