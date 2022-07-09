package com.example.testApi.utils;

import com.example.testApi.constant.RetCodeEnum;
import com.example.testApi.exception.BeanCopyException;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @description: Bean 工具类
 * @author: jianbo.pan
 * @date: 2022/7/8
 * @version: V1.0
 */
@Slf4j
public final class BeanUtils {

    /**
     *  新建目标对象并且拷贝属性
     * @param source
     * @param targetClass
     * @return
     * @param <S>
     * @param <T>
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public static <S,T> T createAndCopy(S source, Class<? extends T> targetClass){
        if(targetClass == null){
            throw new IllegalArgumentException("BeanUtils.copy 请求参数 targetClass为空!");
        }

        Constructor<? extends T> emptyParameterConstructor = null;

        try {
            emptyParameterConstructor = targetClass.getConstructor();
            T target = emptyParameterConstructor.newInstance();
            org.springframework.beans.BeanUtils.copyProperties(source, target);
            return target;
        } catch (NoSuchMethodException e) {
            log.error("BeanUtils.copy 获取 targetClass 的空构造器为空! targetClass = {}", targetClass);
            throw new BeanCopyException(RetCodeEnum.BEAN_COPY_ERROR, e);
        } catch (InvocationTargetException e) {
            log.error("BeanUtils.copy 调用空构造器方法异常! targetClass = {}", targetClass);
            throw new BeanCopyException(RetCodeEnum.INVOKE_EMPTY_CONSTRUCTOR_ERROR, e);
        } catch (InstantiationException e) {
            log.error("BeanUtils.copy 实例化目标对象异常! targetClass = {}", targetClass);
            throw new BeanCopyException(RetCodeEnum.INSTANTIATION_ERROR, e);
        } catch (IllegalAccessException e) {
            log.error("BeanUtils.copy 获取 targetClass 的空构造器为空! targetClass = {}", targetClass);
            throw new BeanCopyException(RetCodeEnum.ILLEGAL_METHOD_ACCESS_ERROR, e);
        }
    }
}