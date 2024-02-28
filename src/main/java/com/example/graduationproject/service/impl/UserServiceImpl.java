package com.example.graduationproject.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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

    @Override
    public boolean selectByUsername(User user) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getuName,user.getuName());
        User username = this.baseMapper.selectOne(wrapper);
        if (username == null){
            return true;
        }
        return false;
    }

    @Override
    public Map<String, Object> getUserInfo(String token) {
        //根据token获取redis中的信息
        Object obj = redisTemplate.opsForValue().get(token);
        if (obj != null){
            //反序列化 将redis中的数据反序列化为Json类型的字符串
//         User loginuser = JSON.parseObject(JSON.toJSONString(obj),User.class);
            User loginuser = JSON.parseObject(JSON.toJSONString(obj), User.class);
            Map<String, Object> data = new HashMap<>();
            data.put("name",loginuser.getuName());
            data.put("avatar",loginuser.getuAvatar());
            return data;
        }


        return null;
    }
}
