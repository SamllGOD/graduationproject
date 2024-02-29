package com.example.graduationproject.service;

import com.example.graduationproject.entity.Businessmen;
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
public interface IBusinessmenService extends IService<Businessmen> {

    Map<String, Object> login(Businessmen businessmen);

    void userlogout(String token);
}
