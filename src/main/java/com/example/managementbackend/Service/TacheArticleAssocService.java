package com.example.managementbackend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.managementbackend.Repository.ArticleRepository;
import com.example.managementbackend.Repository.TacheArticleAssocRepository;
import com.example.managementbackend.Repository.TacheRepository;
import com.example.managementbackend.exception.ResourceNotFoundException;
import com.example.managementbackend.model.TacheArticleAssoc;
import com.example.managementbackend.model.TacheArticleAssocId;

@Service
public class TacheArticleAssocService {
    @Autowired
    private TacheArticleAssocRepository tacheArtRepo;
    
    @Autowired
    private TacheRepository tacheRepo;

    @Autowired
    private ArticleRepository articleRepo;
    
    
    public List<TacheArticleAssoc> getAll() {
        return tacheArtRepo.findAll();
    }


    public List<TacheArticleAssoc> getAllTacheArticleAssocByTcId(long tcId) {
        return tacheArtRepo.findAllByTacheId(tcId);
    }

    public Optional<TacheArticleAssoc> getArticleAssocByTcIdandArtId(Long tcId, Long artId) {
        return tacheArtRepo.findByTacheIdAndArticleId(tcId,artId).map(tacheArticleAssoc ->
        	tacheArtRepo.findByTacheIdAndArticleId(tcId,artId)
        ).orElseThrow(() -> new ResourceNotFoundException("tcId " + tcId + " not found or articleId "+ artId +" not found" ));
    }
    

    public TacheArticleAssoc create(Long tcId, Long articleid, TacheArticleAssoc tacheArticleAssoc) {
        return tacheRepo.findById(tcId).map(tache -> {
            return articleRepo.findById(articleid).map(article -> {
            	tacheArticleAssoc.setId(new TacheArticleAssocId(tcId, articleid));
            	tacheArticleAssoc.setTache(tache);
            	tacheArticleAssoc.setArticle(article);
                return tacheArtRepo.save(tacheArticleAssoc);
                
            }).orElseThrow(() -> new ResourceNotFoundException("articleId " + articleid + " not found"));
            
        }).orElseThrow(() -> new ResourceNotFoundException("tacheId " + tcId + " not found"));
    }
    
}
