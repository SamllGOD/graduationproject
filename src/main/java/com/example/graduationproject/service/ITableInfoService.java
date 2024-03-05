package com.example.graduationproject.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.example.graduationproject.entity.TableInfo;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xxay
 * @since 2024-02-28
 */
public interface ITableInfoService extends IService<TableInfo> {

    Map<String, Object> getTableIdByDiningId(String dinid);
}
