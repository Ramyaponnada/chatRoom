package com.assignment.chatRoom.Repository;


import com.assignment.chatRoom.model.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatMessageRepository extends CrudRepository<Message, Long> {
}
