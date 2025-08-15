package com.example.medicagent;

import com.example.medicagent.assistant.SeparateChatAssistant;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ToolsTest {
    @Resource
    private SeparateChatAssistant separateChatAssistant;

    @Test
    public void testCalculatorTools(){
        String answer = separateChatAssistant.chat(2,"1+2等于几，47561289234的平方根是多少？");
        System.out.println(answer);
    }
}
