package com.example.mytestdemo.Config;

import lombok.Builder;
import lombok.Data;

/**
 * 全局统一数据结构返回
 * @param <T>
 */
@Data
@Builder
public class ApiResult<T> {
    private boolean success;
    private int code;
    private T data;
    private String message;

    //静态方法需要在返回对象前加泛型
    public static <T>ApiResult<T> ok(T t, String message){
        return (ApiResult<T>) ApiResult.builder().code(200).data(t).message(message).success(true).build();
    }
    public static <T>ApiResult<T> ok(T t){
        return (ApiResult<T>) ApiResult.builder().code(200).data(t).success(true).build();
    }

    public static <T>ApiResult<T> err(T t){
        return (ApiResult<T>) ApiResult.builder().code(500).data(t).success(false).build();
    }

    public static <T>ApiResult<T> err(T t,String message){
        return (ApiResult<T>) ApiResult.builder().code(500).data(t).message(message).success(false).build();
    }
}