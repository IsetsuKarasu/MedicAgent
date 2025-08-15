package com.example.medicagent.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("chat_messages")
public class ChatMessages {
    //唯一标识符，映射到MongoDB文档的_id字段
    @Id
    private ObjectId messageId;

    private String memoryId;

    private String content; //存储当前聊天记录列表的Json字符串
}
