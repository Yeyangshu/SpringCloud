package com.yeyangshu.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 结合 eureka，使用服务名，实现自定义接口
 * @author yeyangshu
 * @version 1.0
 * @date 2020/9/23 23:57
 */
@FeignClient(name = "user-provider")
public interface UserApi3 extends RegisterApi {
}
