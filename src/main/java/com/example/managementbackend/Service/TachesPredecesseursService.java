package com.example.managementbackend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.managementbackend.Repository.TacheRepository;
import com.example.managementbackend.Repository.TachesPredecesseursRepository;
import com.example.managementbackend.exception.ResourceNotFoundException;
import com.example.managementbackend.model.Tache;
import com.example.managementbackend.model.TachesPredecesseurs;

@Service
public class TachesPredecesseursService {
    @Autowired
    private TachesPredecesseursRepository tacpredrep;
    
    @Autowired
    private TacheRepository tacheRepo;

    public List<TachesPredecesseurs> findAllByTacheATravId(Long tacheATravId) {
        return tacheRepo.findById(tacheATravId).map(tache -> {
        	return tacpredrep.findAllByTache_a_trav_id(tache);
        }).orElseThrow(() -> new ResourceNotFoundException("tacheATravId " + tacheATravId + " not found"));
    }
    
    public void deletePred(Long tacheATravId, Long tachePTravId) {
    	Optional<Tache> tache1 = tacheRepo.findById(tacheATravId);
        List<TachesPredecesseurs> tp1 = tacpredrep.findAllByTache_a_trav_id2(tache1);
        Optional<Tache> tache2 = tacheRepo.findById(tachePTravId);
	    List<TachesPredecesseurs> tp2 = tacpredrep.findByTache_p_trav_id(tache2);
	    long id = 0;
	    for(TachesPredecesseurs tp : tp1) {
	    	if(tp.getTache_p_trav_id().getId() == (long) tachePTravId) {
	    		id = tp.getId();
	    	}
	    }
	    if(id!=0) {
	    	Optional<TachesPredecesseurs> tptodelete = tacpredrep.findById(id);
	    	tacpredrep.deleteById(id);
	    }
    }
    
    public Optional<TachesPredecesseurs> getById(Long tacheATravId) {
    	Optional<TachesPredecesseurs> tp = tacpredrep.findById(tacheATravId);
    	return tp;
    }

    public TachesPredecesseurs create(Long tacheATravId, Long tachePTravId) {
        return tacheRepo.findById(tacheATravId).map(tache1 -> {
            return tacheRepo.findById(tachePTravId).map(tache2 -> {
            	TachesPredecesseurs tachePreced = new TachesPredecesseurs();
            	tachePreced.setTache_a_trav_id(tache1);
            	tachePreced.setTache_p_trav_id(tache2);
                return tacpredrep.save(tachePreced);
                
            }).orElseThrow(() -> new ResourceNotFoundException("tachePTravId " + tachePTravId + " not found"));
            
        }).orElseThrow(() -> new ResourceNotFoundException("tacheATravId " + tacheATravId + " not found"));
    }
}
