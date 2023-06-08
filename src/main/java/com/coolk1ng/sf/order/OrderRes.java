package com.coolk1ng.sf.order;

import lombok.Data;

import java.util.List;

/**
 * 订单信息响应参数
 *
 * @author coolk1ng
 * @since 2023/5/19 13:05
 */
@Data
public class OrderRes {
    /**
     * 客户订单号
     * required
     */
    private String orderId;
    /**
     * 原寄地区域代码，可用于顺丰 电子运单标签打印
     */
    private String originCode;
    /**
     * 目的地区域代码，可用于顺丰 电子运单标签打印
     */
    private String destCode;
    /**
     * 筛单结果： 1：人工确认 2：可收派 3：不可以收派
     */
    private String filterResult;
    /**
     * 如果filter_result=3时为必填， 不可以收派的原因代码：
     * 1：收方超范围 2：派方超范围 3：其它原因 高峰管控提示信息 【数字】：【高峰管控提示信息】 (如 4：温馨提示 ，1：春运延时)
     * condition
     */
    private String remark;
    /**
     * 二维码URL （用于CX退货操作的URL）
     */
    private String url;
    /**
     * 用于第三方支付运费的URL
     */
    private String paymentLink;
    /**
     * 是否送货上楼 1:是
     */
    private String isUpstairs;
    /**
     * true 包含特殊仓库增值服务
     */
    private String isSpecialWarehouseService;
    /**
     * 下单补充的增值服务信息
     */
    private List<Service> serviceList;
    /**
     * 返回信息扩展属性
     */
    private List<ExtraInfo> returnExtraInfoList;
    /**
     * 顺丰运单号
     */
    private List<WaybillNoInfo> waybillNoInfoList;
    /**
     * 路由标签，除少量特殊场景用户外，其余均会返回
     */
    private List<RouteLabelInfo> routeLabelInfo;
//    private List<ContactInfo> contactInfoList;
}
