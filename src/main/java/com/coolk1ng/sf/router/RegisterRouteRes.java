package com.coolk1ng.sf.router;

import lombok.Data;

/**
 * 路由注册响应参数
 *
 * @author coolk1ng
 * @since 2023/5/19 13:54
 */
@Data
public class RegisterRouteRes {
    private String apiErrorMsg;
    private String apiResponseID;
    private String apiResultCode;
    private RegisterRouteCommonRes apiResultData;
}
