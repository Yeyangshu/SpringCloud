package com.yeyangshu.controller;

import com.yeyangshu.api.ConsumerApi;
import com.yeyangshu.entity.Person;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author yeyangshu
 * @version 1.0
 * @date 2020/10/10 6:49
 */
@Component
public class UserProviderBack implements ConsumerApi {
    @Override
    public Map<Integer, String> getMap(Integer id) {
        return null;
    }

    @Override
    public Map<Integer, String> getMap2(Integer id, String name) {
        return null;
    }

    @Override
    public Map<Integer, String> getMap3(Map<String, Object> map) {
        return null;
    }

    @Override
    public Map<Integer, String> postMap(Map<String, Object> map) {
        return null;
    }

    @Override
    public String isAlive() {
        return "alive降级";
    }

    @Override
    public Person postPerson(Person person) {
        return null;
    }
}