package com.coolk1ng.sf.order;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 顺丰运单号
 *
 * @author coolk1ng
 * @since 2023/5/19 10:00
 */
@Data
public class WaybillNoInfo {
    /**
     * 运单号类型1：母单 2 :子单 3 : 签回单
     */
    private Integer waybillType;
    /**
     * 运单号
     */
    private String waybillNo;
    /**
     * 箱号
     */
    private String boxNo;
    /**
     * 长(cm)
     */
    private BigDecimal length;
    /**
     * 高(cm)
     */
    private BigDecimal height;
    /**
     * 重量(kg)
     */
    private BigDecimal weight;
    /**
     * 体积（立方厘米）
     */
    private BigDecimal volume;
}
