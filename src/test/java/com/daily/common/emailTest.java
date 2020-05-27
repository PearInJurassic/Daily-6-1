package com.daily.common;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Random;

public class emailTest {

    @Test
    @Ignore
    public void test() throws EmailException {
        //生成6位数字随机数
        Random r = new Random();
        int random=r.nextInt(899999)+100000;

        HtmlEmail email=new HtmlEmail();//创建一个HtmlEmail实例对象
        email.setHostName("smtp.163.com");//邮箱的SMTP服务器，一般123邮箱的是smtp.123.com,qq邮箱为smtp.qq.com,163...
        email.setCharset("utf-8");//设置发送的字符类型

        email.addTo("2750201946@qq.com");//设置收件人
        email.setFrom("mkxfzu@163.com","Daily 账户团队");//发送人的邮箱为自己的，用户名可以随便填

        //设置发送人到的邮箱和用户名和授权码(授权码是自己设置的)
        email.setAuthentication("mkxfzu@163.com","LTMCDVCBUSFTCIYM");

        email.setSubject("Daily 账户安全验证码");//设置发送主题
        email.setMsg("Daily 账户安全验证码\n请为您的账户2750201946@qq.com使用以下验证码。\n验证码："+random+"\n\n谢谢！\nDaily 账户团队");//设置发送内容
        email.send();//进行发送
    }
}
