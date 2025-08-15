package com.example.medicagent.controller;

import com.example.medicagent.assistant.MedicAgent;
import com.example.medicagent.bean.ChatForm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@Tag(name = "MedicAgent")
@RestController
@RequestMapping("/medic")
public class MedicController {

    @Resource
    private MedicAgent agent;

    @Operation(summary = "对话")
    @PostMapping(value = "/chat", produces = "text/stream;charset=utf-8")
    public Flux<String> chat(@RequestBody ChatForm chatForm)  {
        return agent.chat(chatForm.getMemoryId(), chatForm.getMessage());
    }
}
