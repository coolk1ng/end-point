package com.coolk1ng.sf.router;

import lombok.Data;

/**
 * 路由注册请求参数
 *
 * @author coolk1ng
 * @since 2023/5/19 13:51
 */
@Data
public class RegisterRouteReq {
    /**
     * 合作伙伴编码（即顾客编码
     */
    private String partnerID;
    /**
     * 请求唯一号UUID
     */
    private String requestID;
    /**
     * 接口服务代码
     */
    private String serviceCode;
    /**
     * 调用接口时间戳
     */
    private String timestamp;
    /**
     * 数字签名,使用数字签名方式认证时必填
     * 签名方法参考：数字签名认证说明
     */
    private String msgDigest;
    /**
     * accessToken,使用OAuth2方式认证时必填
     * 获取方法参考：OAuth2认证说明
     */
    private String accessToken;
    /**
     * 业务报文json
     */
    private String msgData;
}
