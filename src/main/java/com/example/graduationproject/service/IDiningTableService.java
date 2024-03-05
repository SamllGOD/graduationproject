package com.example.graduationproject.service;

import com.example.graduationproject.entity.DiningTable;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xxay
 * @since 2024-02-28
 */
public interface IDiningTableService extends IService<DiningTable> {

    Map<String,Object> setredis(String busingssid);



    Object getdininginfo(String busingssid);

    Map<String,Object> getmessagefordinid(String tableid);

    Map<String, Object> getBusinessDining(String buid);

    void upeTableByDiningTableId(DiningTable diningTable);


}
