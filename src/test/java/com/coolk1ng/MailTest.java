package com.coolk1ng;

import com.coolk1ng.mail.SendMail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * 邮件工具测试类
 *
 * @author coolk1ng
 * @since 2023/2/10 14:30
 */
public class MailTest extends EndPointApplicationTests {
    @Autowired
    private SendMail sendMail;

    /**
     * 发送纯文本邮件
     */
    @Test
    public void sendMailTest1() {
        sendMail.sendMail("codesniperrrrr@gmail.com", "测试邮件", "测试邮件");
    }

    /**
     * 发送附件邮件
     */
    @Test
    public void sendmailTest2() {
        List<File> fileList = new ArrayList<>();
        fileList.add(Paths.get("/usr/local/2022 Wuxi site KPIs.xlsx").toFile());
        fileList.add(Paths.get("/usr/local/WX Tier 4 - 2022 .xlsm").toFile());
        sendMail.sendMail("codesniperrrrr@gmail.com", "测试邮件", "测试邮件", fileList);
    }
}
