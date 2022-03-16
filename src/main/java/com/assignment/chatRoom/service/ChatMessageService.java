package com.assignment.chatRoom.service;
import com.assignment.chatRoom.model.Message;

import java.util.List;

public interface ChatMessageService {

    void save(Message message);

    List<Message> findAll();
}
