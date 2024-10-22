package com.Back_Finan.service;

import com.Back_Finan.model.KnowledgeEntry;
import com.Back_Finan.repository.KnowledgeEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatbotService {

    @Autowired
    private KnowledgeEntryRepository knowledgeEntryRepository;

    public String generateResponse(String userMessage) {
        // Busca si la pregunta ya existe en la base de datos
        return knowledgeEntryRepository.findByQuestion(userMessage)
                .map(KnowledgeEntry::getAnswer)
                .orElseGet(() -> {
                    // Si no existe, responde con un mensaje genérico y guarda en la base de datos
                    String response = "Lo siento, no sé cómo responder a eso.";
                    knowledgeEntryRepository.save(new KnowledgeEntry(userMessage, response));
                    return response;
                });
    }

    // Método para aprender nuevas respuestas
    public void learnResponse(String question, String answer) {
        KnowledgeEntry entry = knowledgeEntryRepository.findByQuestion(question)
                .orElse(new KnowledgeEntry(question, answer));
        entry.setAnswer(answer);
        knowledgeEntryRepository.save(entry);
    }
}
