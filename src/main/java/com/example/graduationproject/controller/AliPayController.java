package com.example.graduationproject.controller;

import cn.hutool.json.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.example.graduationproject.config.AliPayConfig;
import com.example.graduationproject.entity.Order;
import com.example.graduationproject.service.IOrderService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("alipay")
@Transactional(rollbackFor = Exception.class)
public class AliPayController {
    private static final String GATEWAY_URL = "https://openapi-sandbox.dl.alipaydev.com/gateway.do";
    private static  final String FORMAT = "JSON";
    private static final String CHARSET = "UTF-8";
    //签名方式
    private static final String SIGN_TYPE = "RSA2";

    @Resource
    private AliPayConfig aliPayConfig;
    @Resource
    private IOrderService orderService;

    @GetMapping("/pay")
    public void pay( String orderNo, HttpServletResponse httpResponse) throws Exception{
        //查询订单信息
        Order order = orderService.selectByOrderNo(orderNo);
        if (order == null){
            return;
        }
        //创建Client,通用SDK提供的Client，负责调用API
        AlipayClient alipayClient = new DefaultAlipayClient(GATEWAY_URL,aliPayConfig.getAppId(),
                aliPayConfig.getAppPrivateKey(),FORMAT,CHARSET,aliPayConfig.getAlipayPublicKey(),SIGN_TYPE);
        //2.创建Request并设置Request参数
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest(); //发送Request请求
        request.setNotifyUrl(aliPayConfig.getNotifyUrl());
        JSONObject bizContent = new JSONObject();
        bizContent.set("out_trade_no",order.getOrderCenterId());//订单编号我给的数据是订单的id
        bizContent.set("total_amount",order.getTotalPrice());//订单的总金额
        bizContent.set("subject",order.getDiningoptions());//支付的名称
        bizContent.set("product_code","FAST_INSTANT_TRADE_PAY");//固定配置
        request.setBizContent(bizContent.toString());
        request.setReturnUrl("http://localhost:8088/cart");//支付完成后自动跳转的路径
        //执行请求，拿到响应结果，返回给浏览器 支付宝官方给的页面 在这里进行支付
        String form = "";
        try {
            form = alipayClient.pageExecute(request).getBody(); //调用sdk生成表单
        } catch (AlipayApiException e){
            e.printStackTrace();
        }
        httpResponse.setContentType("text/html;charset=" + CHARSET);
        httpResponse.getWriter().write(form);//直接将完整的html输出到页面
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }
    @PostMapping("/notify") //必须是POST接口
    public void payNotify(HttpServletRequest request) throws Exception{
        if (request.getParameter("trade_status").equals("TRADE_SUCCESS")){
            System.out.println("================支付宝异步回调=================");
            Map<String,String> params = new HashMap<>();
            Map<String,String[]> requestParams = request.getParameterMap();
            for (String name : requestParams.keySet()){
                params.put(name,request.getParameter(name));
            }
            String sign = params.get("sign");
            String content = AlipaySignature.getSignCheckContentV1(params);
            boolean checkSignature = AlipaySignature.rsa256CheckContent(content,sign,aliPayConfig.getAlipayPublicKey(),"UTF-8");
//            //支付宝验签
            if (checkSignature){
                //验签通过
                System.out.println("交易名称" + params.get("subject"));
                System.out.println("交易状态" + params.get("trade_status"));
                System.out.println("支付宝交易凭证号" + params.get("trade_no"));
                System.out.println("商户订单号" + params.get("out_trade_no"));
                System.out.println("交易金额" + params.get("total_amount"));
                System.out.println("买家在支付宝唯一id"+params.get("buyer_id"));
                System.out.println("卖家付款时间"+params.get("gmt_payment"));
                System.out.println("买家付款金额"+params.get("buyer_pay_amount"));
                String tradeNo = params.get("out_trade_no"); //订单编号
                String gmtPayment = params.get("gmt_payment");//支付时间
                String alipayTradeNo = params.get("trade_no");//支付宝交易编号
                //更新订单状态为已支付，设置支付信息
//                Order order = orderService.selectByOrderNo(tradeNo);
                //设置订单状态为已支付

                //设置支付时间

                //设置支付宝交易凭证号

                //删除购物车中的商品


            }
         }
    }
}
