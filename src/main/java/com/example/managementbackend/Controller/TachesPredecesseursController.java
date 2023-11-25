package com.example.managementbackend.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.managementbackend.Service.TachesPredecesseursService;
import com.example.managementbackend.model.TachesPredecesseurs;

@RequestMapping("/admin")
@RestController
public class TachesPredecesseursController {
    @Autowired
    private TachesPredecesseursService tcpredService;

    @GetMapping("/tachespredecesseurs/tachebyatravid/{tacheATravId}")
    public List<TachesPredecesseurs> findAllByTacheATravId(@PathVariable(value = "tacheATravId") Long tacheATravId) {
        return tcpredService.findAllByTacheATravId(tacheATravId);
    }

    @GetMapping("/tachespredecesseurs/{tacheATravId}")
    public Optional<TachesPredecesseurs> findById(@PathVariable(value = "tacheATravId") Long tacheATravId) {
        return tcpredService.getById(tacheATravId);
    }

    @PostMapping("/tachespredecesseurs/delete/{tacheATravId}/{tachePTravId}")
    public void deletePred(
    		@PathVariable (value = "tacheATravId") Long tacheATravId,
    		@PathVariable (value = "tachePTravId") Long tachePTravId
        ) {
        tcpredService.deletePred(tacheATravId, tachePTravId);
    }

    @PostMapping("/tachespredecesseurs/add/{tacheATravId}/{tachePTravId}")
    public TachesPredecesseurs createTachePredecesseur(
    		@PathVariable (value = "tacheATravId") Long tacheATravId,
    		@PathVariable (value = "tachePTravId") Long tachePTravId
        ) {
        return tcpredService.create(tacheATravId, tachePTravId);
    }
}
