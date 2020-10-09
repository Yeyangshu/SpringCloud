package com.yeyangshu.controller;

import com.yeyangshu.api.RegisterApi;
import com.yeyangshu.entity.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yeyangshu
 * @version 1.0
 * @date 2020/9/22 23:24
 */
@RestController
public class UserController implements RegisterApi {

    @Value("${server.port}")
    String port;

    /**
     * Controller 实现自定义接口
     *
     * @return
     */
    @Override
    public String isAlive() {
        int i = 1 / 0;
        return "ok";
    }

    private AtomicInteger count = new AtomicInteger();

    public String alive() {
        try {
            System.out.println("准备睡");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int i = count.getAndIncrement();
        System.out.println("好的第：" + i + "次调用");
        return "port:" + port;
    }

    public String getById(Integer id) {
        return null;
    }

    @GetMapping("/getMap")
    public Map<Integer, String> getMap(@RequestParam("id") Integer id) {
        System.out.println("provider /getMap:" + id);
        System.out.println(Collections.singletonMap(id, "Hello World"));
        return Collections.singletonMap(id, "Hello World");
    }

    @GetMapping("/getMap2")
    public Map<Integer, String> getMap2(Integer id, String name) {
        System.out.println(id);
        return Collections.singletonMap(id, name);
    }

    @GetMapping("/getMap3")
    public Map<Integer, String> getMap3(@RequestParam Map<String, Object> map) {
        System.out.println(map);
        return Collections.singletonMap(Integer.parseInt(map.get("id").toString()), map.get("name").toString());
    }

    @PostMapping("/postMap")
    public Map<Integer, String> postMap(@RequestBody Map<String, Object> map) {
        // TODO Auto-generated method stub
        System.out.println(map);
        return Collections.singletonMap(Integer.parseInt(map.get("id").toString()), map.get("name").toString());
    }

    @PostMapping("/postPerson")
    public Person postPerson(@RequestBody Person person) {
        System.out.println(person.toString());
        return person;
    }
}