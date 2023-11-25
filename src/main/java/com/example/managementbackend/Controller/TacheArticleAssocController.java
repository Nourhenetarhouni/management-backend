package com.example.managementbackend.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.managementbackend.Service.TacheArticleAssocService;
import com.example.managementbackend.model.TacheArticleAssoc;


@RequestMapping("/admin")
@RestController
public class TacheArticleAssocController {
    @Autowired
    private TacheArticleAssocService taasService;

    @GetMapping("/articlesbytache")
    public List<TacheArticleAssoc> getAllArticlesutilisees() {
        return taasService.getAll();
    }
    @GetMapping("/taches/{tcId}/articlesbytache")
    public List<TacheArticleAssoc> getAllArticlesByTcId(@PathVariable(value = "tcId") long tcId) {
        return taasService.getAllTacheArticleAssocByTcId(tcId);
    }

    @GetMapping("/taches/{tcId}/articlesbytache/{artId}")
    public Optional<TacheArticleAssoc> getArticleUtiliseeByTcIdandArtId(
    		@PathVariable Long tcId,
    		@PathVariable Long artId
    		) {
        return taasService.getArticleAssocByTcIdandArtId(tcId,artId);
    }

    @PostMapping("/tache/{tcId}/article/{articleid}/articlesbytache")
    public TacheArticleAssoc createArticleUtilisee(
    		@PathVariable (value = "tcId") Long tcId,
    		@PathVariable (value = "articleid") Long articleid,
            @Valid @RequestBody TacheArticleAssoc tachearticle
        ) {
        return taasService.create(tcId, articleid, tachearticle);
    }

}
