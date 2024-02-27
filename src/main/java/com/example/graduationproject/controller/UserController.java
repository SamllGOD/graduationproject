package com.example.graduationproject.controller;

import cn.hutool.core.util.StrUtil;
import com.example.graduationproject.common.vo.Result;
import com.example.graduationproject.entity.User;
import com.example.graduationproject.mapper.UserMapper;
import com.example.graduationproject.service.IUserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xxay
 * @since 2024-02-27
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private RedisTemplate redisTemplate;
    @Resource
   private IUserService userService;

    @PostMapping("/login")
    public Result<Map<String ,Object>> login(@RequestBody User user){
        if (StrUtil.isBlank(user.getuName()) || StrUtil.isBlank(user.getuPwd())){
            return Result.fail("账号或密码不能为空");
        }
    Map<String,Object>  data =  userService.login(user);
        if (data != null){
//            redisTemplate.opsForValue().set('l',user,30, TimeUnit.MINUTES);
            return Result.success(data);
        }
       return Result.fail(2002,"账号或密码错误");
    };

        @PostMapping("/enroll")
    public Result<?> enroller(@RequestBody User user){
//            Result result = userService.selectByUsername(user);
            userService.save(user);
            return Result.success("注册成功");
        }


}
