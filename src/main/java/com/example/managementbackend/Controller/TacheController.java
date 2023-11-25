package com.example.managementbackend.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.managementbackend.Service.TacheService;
import com.example.managementbackend.model.Tache;


@RequestMapping("/admin")
@RestController
public class TacheController {
    @Autowired
    private TacheService tacheService;

    @GetMapping("/bondecommandes/{bcId}/taches")
    public List<Tache> getAllTachesByBcId(@PathVariable(value = "bcId") Long bcId) {
        return tacheService.getAllTachesByBcId(bcId);
    }
    @GetMapping("/taches")
    public List<Tache> getAllTaches() {
        return tacheService.getAll();
    }
    @GetMapping("/taches/{tcId}/byid")
    public Optional<Tache> getById(@PathVariable(value = "tcId") Long tcId) {
        return tacheService.getById(tcId);
    }
    @GetMapping("/tachebycode/{codetc}")
    public Optional<Tache> getTacheByCode(@PathVariable String codetc){
    	return tacheService.getByCode(codetc);
    }
    @PostMapping("/tachebycode/{tcId}")
    public Tache changeTache(@PathVariable Long tcId, @Valid @RequestBody Tache tache){
    	return tacheService.changeTache(tache);
    }
    @PostMapping("/bondecommandes/{bcId}/tache")
    public Tache createTache(
    		@PathVariable (value = "bcId") Long bcId,
    		@Valid @RequestBody Tache tache
    	) {
        System.out.println(tache.getDateDebutNewBC());
        return tacheService.create(bcId,tache);
    }
    @DeleteMapping("/bondecommandes/{bcId}/taches/{tcId}")
    public ResponseEntity<?> deleteTache(
    		@PathVariable (value = "bcId") Long bcId,
            @PathVariable (value = "tcId") Long tcId
        ) {
        return tacheService.delete(bcId, tcId);
    }
}
