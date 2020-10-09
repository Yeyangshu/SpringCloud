package com.yeyangshu.api;

import com.yeyangshu.controller.UserProviderBack;
import com.yeyangshu.entity.Person;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "user-provider", fallback = UserProviderBack.class)
public interface ConsumerApi extends RegisterApi {

    /**
     * 此处的 GetMapping 是提供给 Feign 的，目的是为了组装 url，服务名 + url：user-provider/getMap
     * 此处的 RequestParam 也是提供给 Feign 的，目的是为了提示 Feign 需要传递并组装参数
     * @param id
     * @return
     */
    @GetMapping("/getMap")
    Map<Integer, String> getMap(@RequestParam("id") Integer id);

    @GetMapping("/getMap2")
    Map<Integer, String> getMap2(@RequestParam("id") Integer id, @RequestParam("name") String name);

    @GetMapping("/getMap3")
    Map<Integer, String> getMap3(@RequestParam Map<String, Object> map);

    @PostMapping("/postMap")
    Map<Integer, String> postMap(Map<String, Object> map);

    @PostMapping("/postPerson")
    Person postPerson(Person person);
}