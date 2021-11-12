package com.example.expose.push_notif_utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
	
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // any application that starts with the word app
        config.setApplicationDestinationPrefixes("/app")
        .enableSimpleBroker("/queue");
    }

    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry
                .addEndpoint("*")
                .setAllowedOriginPatterns("*")
                .withSockJS();
    }
}