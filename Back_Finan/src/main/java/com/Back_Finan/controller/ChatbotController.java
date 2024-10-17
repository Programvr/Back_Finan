package com.Back_Finan.controller;

import com.Back_Finan.service.ChatbotService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/chatbot")
public class ChatbotController {

    @Autowired
    private ChatbotService chatbotService;

    @PostMapping("/message")
    public Map<String, String> handleMessage(@RequestBody Map<String, String> request) {
        String userMessage = request.get("userMessage");
        String botResponse = chatbotService.generateResponse(userMessage);

        // Retornar respuesta del bot
        Map<String, String> response = new HashMap<>();
        response.put("userMessage", userMessage);
        response.put("botResponse", botResponse);
        return response;
    }

    // Endpoint para aprender respuestas manualmente
    @PostMapping("/learn")
    public String learnResponse(@RequestBody Map<String, String> request) {
        String userMessage = request.get("userMessage");
        String correctResponse = request.get("correctResponse");

        // Enseñar al chatbot una nueva respuesta
        chatbotService.learnResponse(userMessage, correctResponse);

        return "Respuesta aprendida: " + userMessage + " -> " + correctResponse;
    }
}
