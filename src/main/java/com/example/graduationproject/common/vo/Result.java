package com.example.graduationproject.common.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Result<T> {
    public static  final Integer CODE_SUCCESS = 200; //成功
    public static  final Integer CODE_AUTH_ERROR = 401; //没有权限
    public static  final Integer CODE_SYS_ERROR = 500;//系统错误
    public static  final Integer CODE_ERROR = 405;//接口请求错误

    private Integer code;
    private  String message;
    private  T data;

    public static <T> Result<T> success(){
        return new Result<>(CODE_SUCCESS,"success",null);
    }
    public static <T> Result<T> success(T data){
        return new Result<>(CODE_SUCCESS,"success",data);
    }
    public static <T> Result<T> success(T data,String message){
        return new Result<>(CODE_SUCCESS,message,data);
    }
    public static <T> Result<T> success(String message){
        return new Result<>(CODE_SUCCESS,message,null);
    }
    public static <T> Result<T> fail(){
        return new Result<>(CODE_SYS_ERROR,"系统错误",null);
    }
    public static <T> Result<T> fail(Integer code){
        return new Result<>(code,"fail",null);
    }
    public static <T> Result<T> fail(Integer code,String message){
        return new Result<>(code,message,null);
    }
    public static <T> Result<T> fail(String message){
        return new Result<>(CODE_SYS_ERROR,message,null);
    }






}
