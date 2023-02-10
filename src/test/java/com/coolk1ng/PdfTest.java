package com.coolk1ng;

import com.coolk1ng.pdf.PdfUtils;
import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * pdf测试类
 *
 * @author coolk1ng
 * @since 2023/2/10 14:46
 */
public class PdfTest extends FrameUseApplicationTests{

    /**
     * 阅读pdf文本
     * @return void
     */
    @Test
    void getPdfText() {
        File file = new File("/usr/local/file/deepl译文.pdf");
        System.out.println(PdfUtils.getPdfText(file));
    }
}
