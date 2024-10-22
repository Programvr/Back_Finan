package com.Back_Finan.repository;

import com.Back_Finan.model.KnowledgeEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KnowledgeEntryRepository extends JpaRepository<KnowledgeEntry, Long> {
    Optional<KnowledgeEntry> findByQuestion(String question);
}
