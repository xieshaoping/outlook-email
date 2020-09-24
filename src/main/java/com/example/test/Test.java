package com.example.test;

import com.example.test.core.entity.EmailConfig;
import com.example.test.core.MailUtil;

/**
 * @author XieShaoping
 * @date 2020/9/24
 * @description
 */
public class Test {

    public static void main(String[] args) {
        EmailConfig config = new EmailConfig();
        config.setPassword("Rong0424");
        config.setUserName("xieshaoping@seczone.cn");
        String[] receivers = new String[]{"987319557@qq.com"};
        String content = "<img class=\"fluid-img\" src=\"https://m.360buyimg.com/babel/jfs/t1/4364/2/13953/39652/5bd97a3dE32ffa419/85868d2eb0713d4e.jpg\" style=\"outline: none; -ms-interpolation-mode: bicubic; max-width: 100%; display: block; border: none;\" title=\"Radeon\" width=\"670\">";
        MailUtil.sendByOpenTraining(config,content,receivers);
    }

}
