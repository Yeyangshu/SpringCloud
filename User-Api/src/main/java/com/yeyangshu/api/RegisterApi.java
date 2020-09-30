package com.yeyangshu.api;

import com.yeyangshu.entity.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author yeyangshu
 * @version 1.0
 * @date 2020/9/23 23:52
 */
public interface RegisterApi {

    @GetMapping("/isAlive")
    public String isAlive();

    @PostMapping("/postPerson")
    public Person postPerson(@RequestBody Person person);

}
