package com.coolk1ng.sf.authentication;

import lombok.Data;

/**
 * 认证请求参数
 *
 * @author coolk1ng
 * @since 2023/5/19 11:02
 */
@Data
public class AuthenticateReq {
    /**
     * 合作伙伴编码（即顾客编码）
     */
    private String partnerID;
    /**
     * 合作伙伴密钥 （即校验码）
     */
    private String secret;
    /**
     * 申请类型，填password
     */
    private String grantType;
}
