package com.yeyangshu.controller;

import com.yeyangshu.api.ConsumerApi;
import com.yeyangshu.entity.Person;
import feign.FeignException;
import feign.hystrix.FallbackFactory;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;

import java.util.Map;

/**
 * UserProviderBackFactory 实现 FallbackFactory接 口，并传递一个泛型
 * @author yeyangshu
 * @version 1.0
 * @date 2020/10/10 7:11
 */
@Component
public class UserProviderBackFactory implements FallbackFactory<ConsumerApi> {
    @Override
    public ConsumerApi create(Throwable throwable) {
        // new ConsumerApi，实现接口
        return new ConsumerApi() {
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
            public Person postPerson(Person person) {
                return null;
            }

            @Override
            public String isAlive() {
                System.out.println(throwable);
                System.out.println(ToStringBuilder.reflectionToString(throwable));
                if (throwable instanceof FeignException.InternalServerError) {
                    // 实际工作中，自定义返回码
                    return "远程服务器500" + throwable.getLocalizedMessage();
                } else {
                    return "alive降级";
                }
            }
        };
    }
}
