package com.example.graduationproject.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.graduationproject.entity.Orderinfo;
import com.example.graduationproject.entity.TableInfo;
import com.example.graduationproject.mapper.OrderinfoMapper;
import com.example.graduationproject.mapper.TablerInfoMapper;
import com.example.graduationproject.service.IOrderinfoService;
import com.example.graduationproject.service.ITableInfoService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xxay
 * @since 2024-02-28
 */
@Service
public class TableInfoServiceImpl extends ServiceImpl<TablerInfoMapper, TableInfo> implements ITableInfoService {

    @Override
    public Map<String, Object> getTableIdByDiningId(String dinid) {
        List<Map<String, Object>> tableIdByDiningId = this.baseMapper.getTableIdByDiningId(dinid);
        HashMap<String, Object> map = new HashMap<>();
        map.put("usetable",tableIdByDiningId);
        return map;
    }
}
