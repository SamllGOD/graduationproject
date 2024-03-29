package com.example.graduationproject.service;

import com.example.graduationproject.common.vo.Result;
import com.example.graduationproject.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xxay
 * @since 2024-02-27
 */
public interface IUserService extends IService<User> {

    public Map<String ,Object> login(User user);

    boolean selectByUsername(User user);

    Map<String, Object> getUserInfo(String token);

    void userlogout(String token);


//    public Result selectByUsername(User user);
}
