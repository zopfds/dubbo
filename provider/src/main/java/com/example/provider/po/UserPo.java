package com.example.provider.po;

import lombok.Data;

/**
 * @description: 用户持久层对象
 * @author: jianbo.pan
 * @date: 2022/7/8
 * @version: V1.0
 */
@Data
public class UserPo {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 用户姓名
     */
    private String userName;
}