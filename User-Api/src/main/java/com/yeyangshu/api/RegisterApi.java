package com.yeyangshu.api;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author yeyangshu
 * @version 1.0
 * @date 2020/9/23 23:52
 */
public interface RegisterApi {

    @GetMapping("/isAlive")
    public String isAlive();

}
