package com.coolk1ng.sf.router;

import lombok.Data;

/**
 * 路由注册业务报文
 *
 * @author coolk1ng
 * @since 2023/5/19 13:55
 */
@Data
public class RegisterRouteMsgData {
    /**
     * 1-按订单号注册, 2-按运单号注册默认为1
     */
    private String type;
    /**
     * 订单号或者运单号
     */
    private String attributeNo;
    /**
     * 电话号码后四位
     */
    private String checkPhoneNo;
    private String orderId;
    private String clientIp;
    /**
     * 响应报文的语言， 缺省值为zh-CN，目前支持以下值zh-CN 表示中文简体， zh-TW或zh-HK或 zh-MO表示中文繁体， en表示英文
     */
    private String language;
    private String country;
}
