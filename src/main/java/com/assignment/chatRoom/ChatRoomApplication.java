package com.assignment.chatRoom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ChatRoomApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatRoomApplication.class, args);
	}

}
