package com.evasquare.idea_generator;

import org.springframework.ai.chat.client.ChatClient;

public class Chat {
    private final ChatClient chatClient;

    public Chat(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public String sendMessage(String message) {
        return chatClient.prompt(
                message)
                .toString();
    }
}
