# outlook-email
发送outlook邮件-smtp.office365.com

## java发送outlook邮件-smtp.office365.com

 1. 核心依赖

```xml
     <dependency>
         <groupId>org.apache.commons</groupId>
         <artifactId>commons-email</artifactId>
         <version>1.5</version>
     </dependency>
```

2. 关键代码

```java

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

```
