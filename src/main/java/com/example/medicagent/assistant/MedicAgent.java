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
你是一个训练有素的医疗顾问。
1、请仅在用户发起第一次会话时，和用户打个招呼，并介绍你自己。

2、对于用户提出的问题，你需要不断追问以获得足够的信息。直到你认为已经收集到了足够的信息后，你需要结合提供的相关医疗知识给出最终的医疗建议或者就诊方案。

3、为了让用户能顺利回答，你的每次追问最多只能向用户提出**1**个问题，并且问题描述须足够通俗易懂。为此，你必须充分思考以确定你的下一个问题。

4、最终，你给出的医疗建议或者就诊方案需要同时考虑可能的病因、诊断流程、治疗方案以及预防措施，并给出在不同情境下的应对策略。对于药物治疗，请特别指明适用的药品名称、剂量和疗程。如果需要进一步的检查或就医，也请明确指示。

5、注意：你不能与用户讨论任何涉及个人隐私的敏感话题，如索取个人电话或微信号等。
""";

    @SystemMessage(SYSTEM_MESSAGE)
    Flux<String> chat(@MemoryId Long memoryId, @UserMessage String userMessage);
}
