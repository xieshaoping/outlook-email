package com.example.test.core.entity;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * @author XieShaoping
 */
@Data
public class MailEntity {

    // 邮件编码
    public static final String ENCODING = "UTF-8";
    // 服务器地址
    private String host;
    // 发送端口
    private String port;
    // 发件人邮箱
    private String sender;
    // 发件人昵称
    private String senderName;
    // 发件邮箱账号
    private String userName;
    // 发件邮箱密码
    private String password;
    // 收件人邮箱
    private String[] receiver;
    // 抄送人
    private List<String> copier;
    // 邮件主题
    private String subject;
    // 邮件内容(支持HTML)
    private String content;
    // 模板名称
    private String templateName;
    // 模板内容
    private String template;
    private Map<String, Object> root;
    private Timestamp lastupdate;
    private List<String> cc;
    private String auth;
    private String tls;

}
