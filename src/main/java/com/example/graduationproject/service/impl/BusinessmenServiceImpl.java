package com.example.graduationproject.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.graduationproject.entity.Businessmen;

import com.example.graduationproject.mapper.BusinessmenMapper;

import com.example.graduationproject.service.IBusinessmenService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xxay
 * @since 2024-02-28
 */
@Service
public class BusinessmenServiceImpl extends ServiceImpl<BusinessmenMapper, Businessmen> implements IBusinessmenService {
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Map<String, Object> login(Businessmen businessmen) {
        LambdaQueryWrapper<Businessmen> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Businessmen::getbName, businessmen.getbName());
        wrapper.eq(Businessmen::getbPwd, businessmen.getbPwd());
        Businessmen loginbusinessmen = this.baseMapper.selectOne(wrapper);
        if (loginbusinessmen != null){
            //uuid生成token
            String key  = "user:" + UUID.randomUUID();

            //存入redis 并且在30分钟后过期
            redisTemplate.opsForValue().set(key,loginbusinessmen,30, TimeUnit.MINUTES);
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
    public void userlogout(String token) {
         redisTemplate.delete(token);
    }
}
