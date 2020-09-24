package com.example.test.core;

import com.example.test.core.entity.MailEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import javax.mail.Session;
import java.util.Properties;

/**
 * @author XieShaoping
 */
@Slf4j
public class TLSMailUtil  {

    public static Boolean send(MailEntity mail) {
        HtmlEmail email = new HtmlEmail();
        try {
            Properties pro = new Properties();
            // 设置邮件服务器主机名
            pro.setProperty("mail.smtp.host", mail.getHost());
            pro.setProperty("mail.smtp.port", mail.getPort());
            // 发送服务器需要身份验证
            pro.setProperty("mail.smtp.auth", mail.getAuth());
            pro.setProperty("mail.smtp.starttls.enable", mail.getTls());
            DefaultAuthenticator defaultAuthenticator = new DefaultAuthenticator(mail.getUserName(), mail.getPassword());
            Session session = Session.getInstance(pro, defaultAuthenticator);
            session.setDebug(true);
            email.setMailSession(session);
            email.setCharset(MailEntity.ENCODING);
            email.setFrom(mail.getUserName(), mail.getSenderName());
            email.addTo(mail.getReceiver());
            if (mail.getCopier() != null) {
                if (mail.getCopier().size() > 0) {
                    email.addCc(mail.getCopier().toArray(new String[mail.getCopier().size()]));
                }
            }
            email.setSubject(mail.getSubject());
            email.setMsg(mail.getContent());
            email.send();
            log.info(mail.getSender() + "发送邮箱到" + mail.getReceiver());
            return true;
        } catch (EmailException e) {
            log.info(mail.getSender() + "发送邮箱到" + mail.getReceiver() + "失败，错误原因是" + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

}
