package com.example.testApi.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: 用户传输dto
 * @author: jianbo.pan
 * @date: 2022/7/8
 * @version: V1.0
 */
@Data
public class UserDto implements Serializable {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 用户姓名
     */
    private String userName;
}