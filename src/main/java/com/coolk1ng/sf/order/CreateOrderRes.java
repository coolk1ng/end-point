package com.coolk1ng.sf.order;

import lombok.Data;

/**
 * 下单响应参数
 *
 * @author coolk1ng
 * @since 2023/5/19 13:34
 */
@Data
public class CreateOrderRes {
    private String apiErrorMsg;
    private String apiResponseID;
    private String apiResultCode;
    private CreateOrderCommonRes apiResultData;
}
