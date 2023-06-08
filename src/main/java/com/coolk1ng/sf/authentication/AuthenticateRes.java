package com.coolk1ng.sf.authentication;

import lombok.Data;

/**
 * 认证响应参数(form表单)
 *
 * @author coolk1ng
 * @since 2023/5/19 11:20
 */
@Data
public class AuthenticateRes {
    /**
     * 响应ID
     */
    private String apiResponseID;
    /**
     * 响应码: A1000:成功, A1011:认证失败
     */
    private String apiResultCode;
    /**
     * 错误描述
     */
    private String apiErrorMsg;
    /**
     * 访问令牌
     */
    private String accessToken;
    /**
     * accessToken访问令牌过期时间，单位（秒）,默认7200秒。从申请成功后，开始倒计时7200s,令牌过期后（即expiresIn=0）需要重新获取
     */
    private Integer expiresIn;
}
