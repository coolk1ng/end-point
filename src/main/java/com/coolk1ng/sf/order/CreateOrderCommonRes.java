package com.coolk1ng.sf.order;

import lombok.Data;

/**
 * 公共响应参数
 *
 * @author coolk1ng
 * @since 2023/5/19 13:35
 */
@Data
public class CreateOrderCommonRes {
    /**
     * true 请求成功，false 请求失败
     */
    private String success;
    /**
     * 	错误编码，S0000成功
     */
    private String errorCode;
    /**
     * 错误描述
     */
    private String errorMsg;
    /**
     * 返回的详细数据
     */
    private OrderRes msgData;
}
