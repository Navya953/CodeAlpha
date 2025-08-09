package com.web;
import java.util.*;

public class ChatBot {
    private Map<String, String> responses;

    public ChatBot() {
        responses = new HashMap<>();
        responses.put("hi", "Hello! How can I help you today?");
        responses.put("hello", "Hi there! How’s your day going?");
        responses.put("how are you", "I’m doing great, thanks for asking!");
        responses.put("bye", "Goodbye! Have a nice day!");
        responses.put("name", "I am your Java ChatBot.");
        responses.put("help", "I can answer basic questions like greetings, my name, or how I am.");
    }

    public String getResponse(String input) {
        input = input.toLowerCase().trim();
        return responses.getOrDefault(input, "Sorry, I don't understand that.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ChatBot bot = new ChatBot();
        System.out.println("ChatBot: Hello! Type 'bye' to exit.");

        while (true) {
            System.out.print("You: ");
            String userInput = sc.nextLine();
            if (userInput.equalsIgnoreCase("bye")) {
                System.out.println("ChatBot: " + bot.getResponse("bye"));
                break;
            }
            System.out.println("ChatBot: " + bot.getResponse(userInput));
        }
        sc.close();
    }
}


