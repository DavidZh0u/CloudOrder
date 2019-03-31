package com.paladin.mongo.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class InfoLogEntity {

    private String logLev;

    private String msg;

    private Timestamp timestamp;

}
