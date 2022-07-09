package com.example.provider;

import com.example.provider.dto.UserDto;

import java.util.List;

/**
 * @description:
 * @author: jianbo.pan
 * @date: 2022/6/11
 * @version: V1.0
 */
public interface TestApi {

    List<UserDto> getByUserName(String userName);

    int insert(UserDto userDto);

    UserDto getById(Long id);

    List<UserDto> getAllUsers();
}