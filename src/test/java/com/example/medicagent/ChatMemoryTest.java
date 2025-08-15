package com.example.medicagent;

import com.example.medicagent.assistant.Assistant;
import com.example.medicagent.assistant.MemoryChatAssistant;
import com.example.medicagent.assistant.SeparateChatAssistant;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.service.AiServices;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
 public class ChatMemoryTest {
     @Resource
     private Assistant assistant;
     @Test
     public void testChatMemory() {

          String answer1 = assistant.chat("我是环环");
          System.out.println(answer1);

          String answer2 = assistant.chat("我是谁");
          System.out.println(answer2);
     }
     @Resource
     private ChatModel chatModel;
     @Test
     public void testChatMemory2() {
      //第一轮对话
      UserMessage userMessage1 = UserMessage.userMessage("我是环环");
      ChatResponse chatResponse1 = chatModel.chat(userMessage1);
      AiMessage aiMessage1 = chatResponse1.aiMessage();
      //输出大语言模型的回复
      System.out.println(aiMessage1.text());
      //第二轮对话
      UserMessage userMessage2 = UserMessage.userMessage("你知道我是谁吗");
      ChatResponse chatResponse2 = chatModel.chat(Arrays.asList(userMessage1, aiMessage1, userMessage2));
      AiMessage aiMessage2 = chatResponse2.aiMessage();
     //输出大语言模型的回复
      System.out.println(aiMessage2.text());
     }
     @Test
     public void testChatMemory3(){

          MessageWindowChatMemory chatMemory = MessageWindowChatMemory.withMaxMessages(10);

          Assistant assistant = AiServices
                  .builder(Assistant.class)
                  .chatModel(chatModel)
                  .chatMemory(chatMemory)
                  .build();

          String answer1 = assistant.chat("我是嬛嬛");
          System.out.println(answer1);
          String answer2 = assistant.chat("我是谁？");
          System.out.println(answer2);
     }
     @Resource
     private MemoryChatAssistant memoryChatAssistant;
     @Test
     public void testChatMemory4(){

         String answer1 = memoryChatAssistant.chat("我是华华");
         System.out.println(answer1);
         String answer2 = memoryChatAssistant.chat("我是谁");
         System.out.println(answer2);
     }

    @Resource
    private SeparateChatAssistant separateChatAssistant;
    @Test
    public void testChatMemory5(){

        String answer1 = separateChatAssistant.chat(1,"我是华华");
        System.out.println(answer1);
        String answer2 = separateChatAssistant.chat(1,"我是谁");
        System.out.println(answer2);

        String answer3 = separateChatAssistant.chat(2,"我是谁");
        System.out.println(answer3);
    }
}