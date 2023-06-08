package com.coolk1ng.sf.order;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 报关信息，查看《海关口岸信息表》
 *
 * @author coolk1ng
 * @since 2023/5/19 10:01
 */
@Data
public class CustomsInfo {
    /**
     * 客户订单货物总声明价值， 包含子母件，精确到小数点 后3位。如果是跨境件，则必填
     */
    private BigDecimal declaredValue;
    /**
     * 货物声明价值币别，跨境 件报关需要填写 参照附录币别代码附件
     * default: 中国内地 默认CNY， 否则 默认USD
     */
    private String declaredValueCurrency;
    /**
     * 报关批次
     */
    private String customsBatchs;
    /**
     * 税金付款方式，支持以下值： 1:寄付 2：到付
     */
    private Integer taxPayMethod;
    /**
     * 税金结算账号
     */
    private String taxSettleAccounts;
    /**
     * 支付工具
     */
    private String paymentTool;
    /**
     * 支付号码
     */
    private String paymentNumber;
    /**
     * 客户订单下单人姓名
     */
    private String orderName;
    /**
     * 客户订单下单人证件类型
     */
    private String orderCertType;
    /**
     * 客户订单下单人证件号
     */
    private String orderCertNo;
    /**
     * 税款
     */
    private String tax;
}
