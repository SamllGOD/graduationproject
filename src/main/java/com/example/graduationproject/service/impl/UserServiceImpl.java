package com.example.graduationproject.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.graduationproject.common.exception.ServiceException;
import com.example.graduationproject.common.vo.Result;
import com.example.graduationproject.entity.User;
import com.example.graduationproject.mapper.UserMapper;
import com.example.graduationproject.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xxay
 * @since 2024-02-27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private RedisTemplate redisTemplate;
    @Resource
    UserMapper userMapper;
//redis启动命令 redis-server.exe redis.windows.conf
    @Override
    public Map<String,Object> login(User user) {
        //验证用户账户是否合法
        //查询数据库中是否有这个用户名
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getuName, user.getuName());
        wrapper.eq(User::getuPwd, user.getuPwd());

        User loginuser = this.baseMapper.selectOne(wrapper);
        if (loginuser != null){
           //uuid生成token
            String key  = "user:" + UUID.randomUUID();

            //存入redis
            redisTemplate.opsForValue().set(key,loginuser,30, TimeUnit.MINUTES);



            //返回数据
            Map<String,Object> data = new HashMap<>();
            data.put("token",key);
            return data;
        }
//        if (!user.getuPwd().equals(loginuser.getuPwd())){
//            throw new ServiceException("账号或密码错误");
//        }
//        if (dbuser != null) {
//
//        }

        return null;
    }

//    @Override
//    public Result selectByUsername(User user) {
//        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
//        //将传过来的值与数据库中的数据进行对比
//        wrapper.eq(User::getuName, user.getuName());
//        User loginuser = this.baseMapper.selectOne(wrapper);
//        //如果不为空则用户名已存在
//        if (loginuser != null){
//            return Result.fail("用户名已存在");
//        }
//
//            this.baseMapper.insert(user);
//        return Result.success("注册成功");
//
//
//    }
}
