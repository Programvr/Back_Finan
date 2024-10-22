package com.Back_Finan.model;

import jakarta.persistence.*;

@Entity
@Table(name = "KnowledgeBase")
public class KnowledgeEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;
    private String answer;

    public KnowledgeEntry() {
    }

    public KnowledgeEntry(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
