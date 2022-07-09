package com.example.provider;

import com.example.testApi.TestApi;
import com.example.testApi.dto.UserDto;
import com.example.provider.po.UserPo;
import com.example.provider.user.UserMapper;
import com.example.testApi.utils.BeanUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: jianbo.pan
 * @date: 2022/6/12
 * @version: V1.0
 */
@DubboService
@Lazy(false)
public class TestApiProvider implements TestApi {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserDto> getByUserName(String userName) {
        List<UserPo> userPos = userMapper.getByUserName(userName);
        if(userPos == null){
            return Collections.emptyList();
        }
        return userPos.stream()
                .map(userPo -> BeanUtils.createAndCopy(userPo, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public int insert(UserDto userDto) {
        return userMapper.insert(BeanUtils.createAndCopy(userDto, UserPo.class));
    }

    @Override
    public UserDto getById(Long id) {
        return BeanUtils.createAndCopy(userMapper.getById(id), UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserPo> userPos = userMapper.getAllUsers();
        if(userPos == null){
            return Collections.emptyList();
        }
        return userPos.stream()
                .map(userPo -> BeanUtils.createAndCopy(userPo, UserDto.class))
                .collect(Collectors.toList());
    }
}