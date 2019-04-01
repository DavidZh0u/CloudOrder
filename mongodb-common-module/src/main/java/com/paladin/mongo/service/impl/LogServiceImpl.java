package com.paladin.mongo.service.impl;

import com.paladin.mongo.entity.InfoLogEntity;
import com.paladin.mongo.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * @Author: 周大伟
 * @Date: 2019/4/1 9:47
 */
@Service(value = "logService")
@Async
public class LogServiceImpl implements LogService {


    private static String name = "info_log";

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
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
