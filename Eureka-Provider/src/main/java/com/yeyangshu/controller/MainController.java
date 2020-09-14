package com.yeyangshu.controller;

import com.yeyangshu.service.HealthStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yeyangshu
 * @version 1.0
 * @date 2020/9/14 23:36
 */
@RestController
public class MainController {

    @Autowired
    HealthStatusService healthStatusService;

    @GetMapping("/hi")
    public String getHi() {
        return "hi";
    }

    /**
     * 服务状态上报 controller
     * @param status
     * @return
     */
    @GetMapping("/health")
    public String health(@RequestParam("status") Boolean status) {
        healthStatusService.setStatus(status);
        return healthStatusService.getStatus();
    }
}
