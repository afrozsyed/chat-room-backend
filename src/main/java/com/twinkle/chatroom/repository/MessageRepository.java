package com.twinkle.chatroom.repository;

import com.twinkle.chatroom.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends MongoRepository<Message, String> {
    List<Message> findByChatRoomIdOrderByTimestampAsc(String chatRoomId);
}
