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

直接运行main方法发送邮件
```java
public class Test {

    public static void main(String[] args) {
        EmailConfig config = new EmailConfig();
        //发件人
        config.setPassword("Rong0424");
        config.setUserName("******@*****.cn");
        //收件人
        String[] receivers = new String[]{"987319557@qq.com"};
        String content = "<img class=\"fluid-img\" src=\"https://m.360buyimg.com/babel/jfs/t1/4364/2/13953/39652/5bd97a3dE32ffa419/85868d2eb0713d4e.jpg\" style=\"outline: none; -ms-interpolation-mode: bicubic; max-width: 100%; display: block; border: none;\" title=\"Radeon\" width=\"670\">";
        MailUtil.sendByOpenTraining(config,content,receivers);
    }

}
```
