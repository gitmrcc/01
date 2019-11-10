package com.offcn.mailtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RestController
public class MailController {
    @Autowired
    private JavaMailSenderImpl javaMailSender;
    @RequestMapping("send")
    public String sendMail() throws MessagingException {
        /*SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("中公教育");
        simpleMailMessage.setText("王建东老师，经董事会决定，由于您业绩优秀，现将您的年薪提升至200万，收到请回复");
        simpleMailMessage.setFrom("15169115573@163.com");
        simpleMailMessage.setTo("15169115573@163.com");
        javaMailSender.send(simpleMailMessage);*/

        //可发附件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setSubject("中公教育董事会");
        mimeMessageHelper.setText("<b style='color:red'>王老师，中公教育祝您身体健康，阖家欢乐，财富多多</b>",true);
        mimeMessageHelper.setFrom("15169115573@163.com");
        mimeMessageHelper.setTo("15169115573@163.com");
        mimeMessageHelper.addAttachment("12.jpg",new File("E:\\xm_upload\\12.jpg"));
        mimeMessageHelper.addAttachment("13.jpg",new File("E:\\xm_upload\\13.jpg"));
        javaMailSender.send(mimeMessage);
        return "success";
    }
}
