package com.example.testApi.exception;

import com.example.testApi.constant.RetCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: Bean拷贝异常
 * @author: jianbo.pan
 * @date: 2022/7/8
 * @version: V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BeanCopyException extends RuntimeException{

    /**
     * 错误吗
     */
    private String errorCode;

    /**
     * 错误消息
     */
    private String message;

    /**
     * 构造
     * @param retCodeEnum
     */
    public BeanCopyException(RetCodeEnum retCodeEnum, Throwable cause) {
        super(retCodeEnum.getMessage(), cause);
        this.errorCode = errorCode;
    }
}