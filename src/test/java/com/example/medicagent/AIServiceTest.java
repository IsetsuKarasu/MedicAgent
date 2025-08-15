package com.example.medicagent;

import com.example.medicagent.assistant.Assistant;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.service.AiServices;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AIServiceTest {
    @Resource
    private ChatModel chatModel;

    @Test
    public void testChat(){
        Assistant assistant = AiServices.create(Assistant.class, chatModel);
        String answer = assistant.chat("你好呀！");
        System.out.println(answer);
    }

    @Resource
    private Assistant assistant;

    @Test
    public void testAssiatant(){
        String answer = assistant.chat("你是谁");
        System.out.println(answer);
    }
}
