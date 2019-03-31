package com.paladin.mongo.service;

import com.paladin.mongo.entity.InfoLogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
@Async
public class LogService {

    private static String name = "info_log";

    @Autowired
    private MongoTemplate mongoTemplate;

    public void saveLog() {
        InfoLogEntity entity = new InfoLogEntity();
        entity.setLogLev("普通日志");
        entity.setMsg("xxxxxxxxxxxxxxxxxxxxxxx");
        entity.setTimestamp(new Timestamp(System.currentTimeMillis()));
        System.out.println(entity);
        System.out.println(mongoTemplate.getCollectionNames());
        mongoTemplate.save(entity,name);
        System.out.println("2222222222222222222222");
    }


}
