package com.paladin.mongo.service;

import com.mongodb.client.result.DeleteResult;
import com.paladin.mongo.entity.InfoLogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Component
public class LogService {

    private static String name = "info_log";

    @Autowired
    private MongoTemplate mongoTemplate;

    public void saveLog(String logLev, String msg) {
        InfoLogEntity entity = new InfoLogEntity();
        entity.setLogLev(logLev);
        entity.setMsg(msg);
        entity.setTimestamp(new Date(new Timestamp(System.currentTimeMillis()).getTime()));
        InfoLogEntity cccMd = mongoTemplate.save(entity, name);
        System.out.println(cccMd);
    }

    public InfoLogEntity findInfoLog(String logLev) {
        Query query = new Query(Criteria.where("logLev").is(logLev));
        InfoLogEntity log = mongoTemplate.findOne(query, InfoLogEntity.class);
        return log;
    }

    public int deleteInfoLog(String logLev) {
        Query query = new Query(Criteria.where("logLev").is(logLev));
        DeleteResult result = mongoTemplate.remove(query, InfoLogEntity.class);
        return (int) (result.getDeletedCount());
    }

    public List<InfoLogEntity> findLogByLogLev(String logLev){
        //用来封装所有条件的对象
        Query query = new Query();
        //用来构建条件
        Criteria criteria = new Criteria();
        /**
         *  criteria.and().is() 在这里是构建了一个精准查询的条件，并且用 'and' 相连
         *  query.addCriteria 把条件封装起来
         */
        query.addCriteria(criteria.and("logLev").is(logLev));
        return  mongoTemplate.find(query,InfoLogEntity.class,"info_log");
    }
}