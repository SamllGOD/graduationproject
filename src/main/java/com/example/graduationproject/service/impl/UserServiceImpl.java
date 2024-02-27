package com.example.graduationproject.service.impl;

import com.example.graduationproject.entity.User;
import com.example.graduationproject.mapper.UserMapper;
import com.example.graduationproject.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
