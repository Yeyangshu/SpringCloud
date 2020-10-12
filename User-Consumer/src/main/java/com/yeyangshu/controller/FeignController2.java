package com.yeyangshu.controller;

import com.yeyangshu.api.ConsumerApi;
import com.yeyangshu.entity.Person;
import com.yeyangshu.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author yeyangshu
 * @version 1.0
 * @date 2020/9/30 9:03
 */
@RestController
public class FeignController2 {

    @Autowired
    ConsumerApi api;

    @Autowired
    RestService restService;

    @Value("${server.port}")
    String port;

    @Value("${config.info}")
    String gitConfigInfo;

    @GetMapping
    public String getConfig() {
        return gitConfigInfo;
    }

    @GetMapping("/alive")
    public String alive() {
        return api.isAlive();
    }

    /**
     * 添加 consumer port，测试 Zuul 网关负载均衡
     * @return
     */
    @GetMapping("/alive2")
    public String alive2() {
        return "consumer port:" + port + restService.alive();
    }

    /**
     * 传递一个参数
     *
     * @param id
     * @return
     */
    @GetMapping("/map")
    public Map<Integer, String> map(Integer id) {
        System.out.println(id);
        return api.getMap(id);
    }

    /**
     * 传递多个参数
     *
     * @param id
     * @param name
     * @return
     */
    @GetMapping("/map2")
    public Map<Integer, String> map2(Integer id, String name) {
        System.out.println(id);
        return api.getMap2(id, name);
    }

    /**
     * 传递 map，也可以自己组装 map 发送
     *
     * @param map
     * @return
     */
    @GetMapping("/map3")
    public Map<Integer, String> map3(@RequestParam Map<String, Object> map) {
        System.out.println(map);
        return api.getMap3(map);
    }

    /**
     * post 请求
     *
     * @param map
     * @return
     */
    @PostMapping("/map4")
    public Map<Integer, String> map4(@RequestParam Map<String, Object> map) {
        System.out.println(map);
        return api.postMap(map);
    }

    /**
     * post 请求，接收对象
     *
     * @param person
     * @return
     */
    @PostMapping("/person")
    public Person object(@RequestBody Person person) {
        System.out.println(person);
        return api.postPerson(person);
    }
}