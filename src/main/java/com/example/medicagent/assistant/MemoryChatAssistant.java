package com.example.medicagent.assistant;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;
import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

@AiService(
        wiringMode = EXPLICIT,
        chatModel = "openAiChatModel",
        chatMemory = "chatMemory"
)
public interface MemoryChatAssistant {

     @UserMessage("你是我的好朋友，请用天津话回答问题，并且添加一些表情符号。 {{message}}")
     String chat(@V("message")String message);
}
