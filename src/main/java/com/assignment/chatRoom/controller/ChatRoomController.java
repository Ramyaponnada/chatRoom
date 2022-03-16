package com.assignment.chatRoom.controller;

import com.assignment.chatRoom.model.Message;
import com.assignment.chatRoom.service.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
public class ChatRoomController {

    @Autowired
    private ChatMessageService chatMessageService;

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public Message sendMessage(@Payload Message message) {
        chatMessageService.save(message);
        return message;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public List<Message> addUser(@Payload Message message,
                               SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        Map<String, Object> sessionAttributes = headerAccessor.getSessionAttributes();
        Objects.requireNonNull(sessionAttributes, "Session attributes cant be null");
        sessionAttributes.put("groupChatUser", message.getSender());
        chatMessageService.save(message);

        // return chat history
        return chatMessageService.findAll();
    }
}
