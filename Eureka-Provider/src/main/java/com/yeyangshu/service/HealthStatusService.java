package com.yeyangshu.service;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Service;

/**
 * @author yeyangshu
 * @version 1.0
 * @date 2020/9/15 0:31
 */
@Service
public class HealthStatusService implements HealthIndicator {

    private Boolean status = true;

    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * 上报状态信息
     * @return
     */
    @Override
    public Health health() {
        // TODO Auto-generated method stub
        if (status)
            return new Health.Builder().up().build();
        return new Health.Builder().down().build();
    }

    public String getStatus() {
        // TODO Auto-generated method stub
        return this.status.toString();
    }
}
