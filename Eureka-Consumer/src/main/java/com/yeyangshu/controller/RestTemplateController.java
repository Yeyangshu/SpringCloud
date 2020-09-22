package com.yeyangshu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplate 远程服务调用controller
 *
 * @author yeyangshu
 * @version 1.0
 * @date 2020/9/22 22:56
 */
@RestController
public class RestTemplateController {
    @Autowired
    RestTemplate restTemplate;

    /**
     *
     * @return
     */
    @GetMapping("/client10")
    public Object client10() {
        // 自动处理URL
        String url ="http://provider/hi";
        ResponseEntity<String> respStr = restTemplate.getForEntity(url, String.class);
        System.out.println(respStr);
        return respStr.getBody();
    }
}
