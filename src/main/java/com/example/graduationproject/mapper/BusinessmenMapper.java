package com.example.graduationproject.mapper;

import com.example.graduationproject.entity.Businessmen;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xxay
 * @since 2024-02-28
 */
public interface BusinessmenMapper extends BaseMapper<Businessmen> {

    void  UpdateDiningImgByBusinessId(String diningimg,String buid);

    List<Map<String,Object>> selectDiningImgBybuId(String buid);

}
