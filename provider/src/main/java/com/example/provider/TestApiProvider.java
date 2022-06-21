package com.example.provider;

import org.apache.dubbo.config.annotation.DubboService;

/**
 * @description:
 * @author: jianbo.pan
 * @date: 2022/6/12
 * @version: V1.0
 */
@DubboService
public class TestApiProvider implements TestApi{
    @Override
    public String testMethod(String param) {
        return param + "test";
    }
}