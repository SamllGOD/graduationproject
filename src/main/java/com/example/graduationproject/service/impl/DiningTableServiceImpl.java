package com.example.graduationproject.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.graduationproject.common.vo.Result;
import com.example.graduationproject.entity.DiningTable;
import com.example.graduationproject.mapper.DiningTableMapper;
import com.example.graduationproject.service.IDiningTableService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;
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
public class DiningTableServiceImpl extends ServiceImpl<DiningTableMapper, DiningTable> implements IDiningTableService {

    @Resource
   private RedisTemplate redisTemplate;
    @Override
    public Map<String,Object> setredis(String busingssid) {
            // 逻辑：先比对传过来的商家id 将数据获取然后存入redis中  每当发生增删改时重新将数据存入redis中
            //1.先比对传过来的商家id
        List<DiningTable> allByBusinesstable = this.baseMapper.getAllByBusinessId(busingssid);
        //2.数据获取然后存入redis中
        if (allByBusinesstable != null){
            //代表获取到了数据
            String key = "dining:"+UUID.randomUUID();
            //存入redis中的数据在30分钟后过期
            redisTemplate.opsForValue().set(key,allByBusinesstable,30, TimeUnit.MINUTES);
            //将key返回回去 以后要查询数据使用key在redis中查找
            HashMap<String, Object> data = new HashMap<>();
            data.put("tredis",key);
            data.put("buid",busingssid);

            return data;
        }
        return null;
    }


    //实现获取餐厅信息
    @Override
    public Object getdininginfo(String token) {
        Object o = redisTemplate.opsForValue().get(token);
            return o;
    }


    //根据餐厅餐桌id获取餐桌
    @Override
    public Map<String,Object> getmessagefordinid(String tableid) {
        DiningTable tablemessage = this.baseMapper.selectById(tableid);
        HashMap<String, Object> data = new HashMap<>();
        data.put("tabledata",tablemessage);
        return data;
    }

    @Override
    public Map<String, Object> getBusinessDining(String buid) {
        List<Map<String, Object>> maps = this.baseMapper.getBusinessDining(buid);
        HashMap<String, Object> data = new HashMap<>();
        data.put("BusinessDiningType",maps);


        return data;
    }

    @Override
    public void upeTableByDiningTableId(DiningTable diningTable) {
         this.baseMapper.updateTableByTableId(diningTable);
        return ;
    }


}
