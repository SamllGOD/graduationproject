package com.example.graduationproject.config;



import org.springframework.boot.context.properties.ConfigurationProperties;

import org.springframework.stereotype.Component;


@Component
//读取yml文件中alipay 开头的配置
@ConfigurationProperties(prefix = "alipay")
public class AliPayConfig{
        //应用id
        private String appId;
        //私钥
        private String appPrivateKey;
        //公钥
        private String alipayPublicKey;
        //支付宝网关
//        private String gateway;
        //支付成功后的接口回调地址，不是回调的友好页面，不要弄混了
        //支付宝通知本的接口完整地址
        private String notifyUrl;

    private String returnUrl;
    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppPrivateKey() {
        return appPrivateKey;
    }

    public void setAppPrivateKey(String appPrivateKey) {
        this.appPrivateKey = appPrivateKey;
    }

    public String getAlipayPublicKey() {
        return alipayPublicKey;
    }

    public void setAlipayPublicKey(String alipayPublicKey) {
        this.alipayPublicKey = alipayPublicKey;
    }


    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }
}




