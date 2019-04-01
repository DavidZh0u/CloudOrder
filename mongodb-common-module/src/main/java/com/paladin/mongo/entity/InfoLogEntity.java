package com.paladin.mongo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class InfoLogEntity {

    private String logLev;

    private String msg;

    private Date timestamp;

}
