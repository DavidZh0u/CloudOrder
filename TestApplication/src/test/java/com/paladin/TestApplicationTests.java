package com.paladin;

import com.paladin.mongo.entity.InfoLogEntity;
import com.paladin.mongo.service.LogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private LogService logService;

    @Test
    public void testMongoDB(){
        logService.saveLog("屌几把日志","烦滴很烦滴很烦滴很烦滴很烦滴很");
    }

    @Test
    public void testFindEntity(){
        InfoLogEntity log = logService.findInfoLog("重要");
        System.out.println(log);
    }

    @Test
    public void testDelete(){
        System.out.println(logService.deleteInfoLog("重要"));
    }

    @Test
    public void testFindOne(){
        List<InfoLogEntity> infos = logService.findLogByLogLev("屌几把日志");
        for (InfoLogEntity entity : infos) {
            System.out.println(entity);
        }
    }
}
