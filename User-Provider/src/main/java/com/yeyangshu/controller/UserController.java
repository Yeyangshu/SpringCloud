package com.yeyangshu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yeyangshu
 * @version 1.0
 * @date 2020/9/22 23:24
 */
@RestController
public class UserController {

    @GetMapping("/alive")
    public String alive() {
        return "ok";
    }

}
