package com.example.testApi.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @description:
 * @author: jianbo.pan
 * @date: 2022/7/8
 * @version: V1.0
 */
@AllArgsConstructor
@Getter
public enum RetCodeEnum {

    BEAN_COPY_ERROR("C00001", "Bean拷贝异常"),
    INVOKE_EMPTY_CONSTRUCTOR_ERROR("C00002", "调用空构造器异常"),
    INSTANTIATION_ERROR("C00003", "实例化异常"),
    ILLEGAL_METHOD_ACCESS_ERROR("C00004", "请求方法非法，请检查方法修饰符"),
    ;

    /**
     * 错误码
     */
    private String code;

    /**
     * 错误信息
     */
    private String message;
}