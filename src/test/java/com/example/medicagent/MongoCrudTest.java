package com.example.medicagent;

import com.example.medicagent.bean.ChatMessages;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

@SpringBootTest
public class MongoCrudTest {
    @Resource
    private MongoTemplate mongoTemplate;

    @Test
    public void testInsert(){
        ChatMessages chatMessages = new ChatMessages();
        chatMessages.setContent("聊天记录列表");
        mongoTemplate.insert(chatMessages);
    }

    @Test
    public void testFindById(){
        ChatMessages chatMessages = mongoTemplate.findById("6814b38ce8cdbd475e4e40ba", ChatMessages.class);
        System.out.println(chatMessages);
    }

    @Test
    public void testUpdate(){
        Criteria criteria = Criteria.where("_id").is("6814b38ce8cdbd475e4e40ba");
        Query query = new Query(criteria);
        Update update = new Update();
        update.set("content", "新的聊天记录");
        // 修改或新增
        mongoTemplate.upsert(query, update, ChatMessages.class);
    }

    @Test
    public void testUpdate2(){
        Criteria criteria = Criteria.where("_id").is("100");
        Query query = new Query(criteria);
        Update update = new Update();
        update.set("content", "新增的聊天记录");
        // 修改或新增
        mongoTemplate.upsert(query, update, ChatMessages.class);
    }
    @Test
    public void testDelete(){
        Criteria criteria = Criteria.where("_id").is("100");
        Query query = new Query(criteria);
        mongoTemplate.remove(query, ChatMessages.class);
    }

}
