package com.example.managementbackend.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.managementbackend.model.Article;
import com.example.managementbackend.model.TacheArticleAssoc;
import com.example.managementbackend.model.TacheArticleAssocId;

@Repository
public interface TacheArticleAssocRepository extends JpaRepository<TacheArticleAssoc, TacheArticleAssocId> {
    List<TacheArticleAssoc> findAllByTacheId(long tacheId);
    Optional<TacheArticleAssoc> findByTacheIdAndArticleId(long tacheId, long articleId);

}
