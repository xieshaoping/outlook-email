package com.example.test.core.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author XieShaoping
 */
@Data
public class EmailConfig {

    private String host;
    private String port;
    private String senderName;
    private String userName;
    private String password;
    private String auth;
    private String tls;
    private Timestamp createTime;
    private Timestamp modifyTime;

}
