package com.example.graduationproject.controller;

import cn.hutool.core.util.StrUtil;
import com.example.graduationproject.common.vo.Result;
import com.example.graduationproject.entity.Businessmen;
import com.example.graduationproject.entity.User;
import com.example.graduationproject.service.IBusinessmenService;
import com.example.graduationproject.service.IUserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xxay
 * @since 2024-02-28
 */
@RestController
@RequestMapping("/business")
public class BusinessmenController {

    @Autowired
    private RedisTemplate redisTemplate;
 @Resource
 private IBusinessmenService businessmenService;



    @PostMapping("login")
    public Result<Map<String,Object>> login(@RequestBody Businessmen businessmen){
        if (StrUtil.isBlank(businessmen.getbName()) || StrUtil.isBlank(businessmen.getbPwd())){
            return Result.fail("账号或密码为空");
        }
        Map<String,Object> data = businessmenService.login(businessmen);
        if (data != null){
            return Result.success(data,"登录成功");
        }
        return Result.fail(2002,"账号或密码错误");
    }


    @GetMapping("/logout")
    public Result<?> logout(@RequestParam("token") String token){
        businessmenService.userlogout(token);
        return Result.success("已退出");
    }


    @GetMapping("/info")
    public Result<Map<String ,Object>> getbusinessinfo(@RequestParam("token") String token){
        //根据token来获取用户信息
        Map<String,Object> data = businessmenService.getbusinessInfo(token);
        if (data!=null){
            return Result.success(data);
        }
        return Result.fail(2003,"登录过期");
    }


}
