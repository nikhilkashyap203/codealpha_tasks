package AIChatBot;

import java.util.*;

public class Chatbot {
    private final Map<String, String> knowledgeBase;

    public Chatbot() {
        knowledgeBase = new HashMap<>();
        TrainBot();
    }

    private void TrainBot() {
        knowledgeBase.put("hi", "Hello! How can I help you?");
        knowledgeBase.put("hello", "Hi there! What can I do for you?");
        knowledgeBase.put("what is your name", "I am an AI chatbot built in Java.");
        knowledgeBase.put("What are you doing", "I am doing to guide you.");
        knowledgeBase.put("Give me your source code", "Sorry! But I can't share you source code.");
        knowledgeBase.put("how are you", "I'm just a bunch of code, but thanks for asking me!");
        knowledgeBase.put("bye", "Goodbye! Have a nice day.");
        knowledgeBase.put("help", "You can ask me anything about Java, AI, or programming!");
        
    }

    public String GetResponse(String input) {
        input = input.toLowerCase().trim();
        for (String key : knowledgeBase.keySet()) {
            if (input.contains(key)) {
                return knowledgeBase.get(key);
            }
        }
        return "I'm sorry, I don't understand. Can you rephrase it?";
    }
}