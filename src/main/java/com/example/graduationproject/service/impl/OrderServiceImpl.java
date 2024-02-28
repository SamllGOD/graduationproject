package com.example.graduationproject.service.impl;

import com.example.graduationproject.entity.Order;
import com.example.graduationproject.mapper.OrderMapper;
import com.example.graduationproject.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xxay
 * @since 2024-02-28
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}
