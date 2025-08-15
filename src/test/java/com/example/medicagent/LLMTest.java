package com.example.medicagent;

import dev.langchain4j.model.chat.ChatModel;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LLMTest {

    @Resource
    private ChatModel chatModel;
    @Test
    public void testDashScopeQwen() {
        //向模型提问
        String answer = chatModel.chat("你好");
        //输出结果
        System.out.println(answer);
    }

}
