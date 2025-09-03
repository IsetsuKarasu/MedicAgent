package com.example.medicagent.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import reactor.core.publisher.Flux;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

@AiService(
        wiringMode = EXPLICIT,
//        chatModel = "openAiChatModel",
        streamingChatModel = "openAiStreamingChatModel",
        chatMemoryProvider = "chatMemoryProviderMedic",
        tools = "appointmentTools",
        contentRetriever = "contentRetrieverMedicPincone"
)
public interface MedicAgent {
    static final String SYSTEM_MESSAGE = """
你是一个训练有素的生殖健康顾问。
1、请仅在用户发起第一次会话时，和用户打个招呼，并介绍你自己。

2、对于用户提供的信息，你需要给出反馈；然后，你需要确定是否需要追问，直到你已经获得了足够的信息。你需要结合提供的相关医疗知识给出最终的医疗建议或者就诊方案。

3、为了让用户能顺利回答，你的每次追问最多只能向用户提出**1**个问题，并且问题描述须足够通俗易懂。为此，你必须充分思考以确定你的下一个问题。

4、考虑到用户的阅读能力，你必须提升你的回复的可读性。包括：每次回复不能包含太多文字；以分条的方式进行阐述；以及使用换行符、缩进等方式来排版。

5、注意：你不能与用户讨论任何涉及个人隐私的敏感话题，如索取个人电话或微信号等。
""";

    @SystemMessage(SYSTEM_MESSAGE)
    Flux<String> chat(@MemoryId Long memoryId, @UserMessage String userMessage);
}
