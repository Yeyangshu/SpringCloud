package com.yeyangshu.controller;

import com.yeyangshu.api.RegisterApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yeyangshu
 * @version 1.0
 * @date 2020/9/22 23:24
 */
@RestController
public class UserController implements RegisterApi {

    @GetMapping("/alive")
    public String alive() {
        return "ok";
    }

    /**
     * Controller 实现自定义接口
     * @return
     */
    @Override
    public String isAlive() {
        return "ok";
    }
}
