package com.coolk1ng.mail;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

/**
 * 发送邮件
 *
 * @author coolk1ng
 * @since 2023/1/13 14:39
 */
@Component
public class SendMail {
    private static final Logger logger = LoggerFactory.getLogger(SendMail.class);

    @Autowired
    private JavaMailSender mailSender;
    @Value("${spring.mail.from}")
    private String from;

    /**
     * 发送纯文本邮件信息
     * @param to 接收方
     * @param subject 标题
     * @param content 内容
     * @return void
     */
    public void sendMail(String to, String subject, String content) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from);
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(content);
        mailSender.send(mailMessage);
        logger.info("邮件发送成功,发送到:{}", to);
    }

    /** 
     * 发送带附件的邮件信息
     * @param to 接收方
     * @param subject 主题
     * @param content 内容
     * @param fileList 附件列表
     * @return void
     */
    public void sendMail(String to, String subject, String content, List<File> fileList) {
        MimeMessage mineMessage = mailSender.createMimeMessage();
        //解决附件文件名过长乱码问题
        System.setProperty("mail.mime.splitlongparameters","false");
        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mineMessage, true);
            messageHelper.setFrom(from);
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            messageHelper.setText(content);
            if (!CollectionUtils.isEmpty(fileList)) {
                fileList.forEach(item -> {
                    try {
                        messageHelper.addAttachment(MimeUtility.encodeWord(item.getName(), "utf-8", "B"), item);

                    } catch (MessagingException | UnsupportedEncodingException e) {
                        logger.info("添加附件失败");
                        throw new RuntimeException(e);
                    }
                });
            }
        } catch (MessagingException e) {
            logger.info("发送邮件失败");
            throw new RuntimeException(e);
        }
        mailSender.send(mineMessage);
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONStringWithDateFormat(new Person("张三", new Date()), "yyyy/MM/dd HH:mm:ss", SerializerFeature.WriteNullStringAsEmpty));
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Person {
    private String name;
    private Date birth;
}
