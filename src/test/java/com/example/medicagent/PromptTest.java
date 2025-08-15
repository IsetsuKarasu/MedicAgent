package com.example.medicagent;
import com.example.medicagent.assistant.MemoryChatAssistant;
import com.example.medicagent.assistant.SeparateChatAssistant;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PromptTest {
    @Resource
    private SeparateChatAssistant separateChatAssistant;

    @Test
    public void testSystemMessage(){
        String answer = separateChatAssistant.chat(5,"今天几号");
        System.out.println(answer);
    }

    @Resource
    private MemoryChatAssistant memoryChatAssistant;
    @Test
    public void testUserMessage() {
        String answer1 = memoryChatAssistant.chat("我是环环");
        System.out.println(answer1);

        String answer2 = memoryChatAssistant.chat("我18了");
        System.out.println(answer2);

        String answer3 = memoryChatAssistant.chat("我来自山西省阳泉市");
        System.out.println(answer3);
    }
}
