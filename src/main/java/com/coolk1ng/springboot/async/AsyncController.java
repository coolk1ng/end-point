package com.coolk1ng.springboot.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author coolk1ng
 * @since 2023/3/28 15:45
 */
@RestController
@Slf4j
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/generateReport")
    public void generateReport() {
        asyncService.generateReport();
        log.info("生成成功!!!!!!");
    }
}
