package com.yeyangshu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yeyangshu
 * @version 1.0
 * @date 2020/9/14 23:36
 */
@RestController
public class MainController {

    @GetMapping("/hi")
    public String getHi() {
        return "hi";
    }
}
