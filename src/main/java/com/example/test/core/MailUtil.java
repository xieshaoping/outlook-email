package com.example.test.core;

import com.example.test.core.entity.EmailConfig;
import com.example.test.core.entity.MailEntity;
import lombok.extern.slf4j.Slf4j;


/**
 * @author XieShaoping
 * @date 2020/6/15
 * @description
 */
@Slf4j
public class MailUtil {

    public static boolean send(EmailConfig config, String subjectName, String emailContent, String... receiver) {
        MailEntity mailEntity = new MailEntity();
        // 发件人邮箱
        mailEntity.setUserName(config.getUserName());
        // 发件人昵称
        mailEntity.setSender(config.getSenderName());
        mailEntity.setPassword(config.getPassword());
        mailEntity.setSubject(subjectName);
        mailEntity.setHost("smtp.office365.com");
        mailEntity.setPort("587");
        mailEntity.setAuth("true");
        mailEntity.setTls("true");
        //邮件内容
        mailEntity.setContent(emailContent);
        //收件人
        mailEntity.setReceiver(receiver);
        //发送
        TLSMailUtil.send(mailEntity);
        log.info("邮件发送成功");
        return true;
    }

    public static boolean sendByOpenTraining(EmailConfig config, String emailContent, String... receiver){
        String subjectName = "培训视频";
        return send(config, subjectName,emailContent, receiver);
    }

}
