package com.assignment.chatRoom.service;

import com.assignment.chatRoom.Repository.ChatMessageRepository;
import com.assignment.chatRoom.model.Message;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ChatMessageServiceImpl implements  ChatMessageService{

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @Cacheable("message")
    public List<Message> findAll() {
        List<Message> messages = new ArrayList<>();
        chatMessageRepository.findAll()
                .forEach(messages::add);
        return messages;
    }

    @CachePut(value = "message", key = "#message.user")
    public void save(Message chatMessage) {
        chatMessageRepository.save(chatMessage);
    }
}
