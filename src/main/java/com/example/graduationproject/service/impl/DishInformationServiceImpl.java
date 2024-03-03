package com.example.graduationproject.service.impl;

import cn.hutool.core.lang.hash.Hash;
import com.example.graduationproject.entity.DishInformation;
import com.example.graduationproject.mapper.DishInformationMapper;
import com.example.graduationproject.service.IDishInformationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
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
public class DishInformationServiceImpl extends ServiceImpl<DishInformationMapper, DishInformation> implements IDishInformationService {
    @Resource
   private RedisTemplate redisTemplate;
    @Override
    public Map<String,Object> setredis(String businessid) {
        List<DishInformation> dishdata = this.baseMapper.getAllByBusinessId(businessid);
        if (dishdata != null){
            String key = "dish:"+ UUID.randomUUID();
            redisTemplate.opsForValue().set(key,dishdata,30, TimeUnit.MINUTES);
            HashMap<String, Object> map = new HashMap<>();
            map.put("key",key);
            return map;
        }
        return null;
    }

    @Override
    public Object dishinfo(String token) {
        Object o = redisTemplate.opsForValue().get(token);
        return o;
    }

    @Override
    public Map<String, Object> getdishmessagefordishid(String dishid) {
        DishInformation dishInformation = this.baseMapper.getDishmessageByDishId(dishid);
            if (dishInformation != null){
                HashMap<String, Object> map = new HashMap<>();
                map.put("dishdata",dishInformation);
                return map;
            }
        return null;
    }


}
