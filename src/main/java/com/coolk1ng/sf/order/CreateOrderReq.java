package com.coolk1ng.sf.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 下单请求参数
 *
 * @author coolk1ng
 * @since 2023/5/19 09:57
 */
@Data
public class CreateOrderReq {
    /**
     * 响应报文的语言， 缺省值为zh-CN，目前支持以下值zh-CN 表示中文简体， zh-TW或zh-HK或 zh-MO表示中文繁体， en表示英文
     * required
     */
    private String language;
    /**
     * 客户订单号，重复使用订单号时返回第一次下单成功时的运单信息
     * required
     */
    private String orderId;
    /**
     * 顺丰运单号
     */
    private List<WaybillNoInfo> waybillNoInfoList;
    /**
     * 报关信息，查看《海关口岸信息表》
     */
    private CustomsInfo customsInfo;
    /**
     * 托寄物信息
     * required
     */
    private List<CargoDetail> cargoDetails;
    /**
     * 拖寄物类型描述,如： 文件，电子产品，衣服等
     */
    private String cargoDesc;
    /**
     * 扩展属性
     */
    private List<ExtraInfo> extraInfoList;
    /**
     * 增值服务信息，支持附录： 《增值服务产品表》
     */
    private List<Service> serviceList;
    /**
     * 收寄双方信息
     * required
     */
    private List<ContactInfo> contactInfoList;
    /**
     * 顺丰月结卡号 月结支付时传值，现结不需传值；沙箱联调可使用测试月结卡号7551234567（非正式，无须绑定，仅支持联调使用）
     * condition
     */
    private String monthlyCard;
    /**
     * 付款方式，支持以下值： 1:寄方付 2:收方付 3:第三方付
     */
    private Integer payMethod;
    /**
     * 快件产品类别， 支持附录 《快件产品类别表》 的产品编码值，仅可使用与顺丰销售约定的快件产品
     * required
     */
    private Integer expressTypeId;
    /**
     * 包裹数，一个包裹对应一个运单号；若包裹数大于1，则返回一个母运单号和N-1个子运单号
     */
    private Integer parcelQty;
    /**
     * 客户订单货物总长，单位厘米， 精确到小数点后3位， 包含子母件
     */
    private BigDecimal totalLength;
    /**
     * 客户订单货物总宽，单位厘米， 精确到小数点后3位， 包含子母件
     */
    private BigDecimal totalWidth;
    /**
     * 客户订单货物总高，单位厘米， 精确到小数点后3位， 包含子母件
     */
    private BigDecimal totalHeight;
    /**
     * 订单货物总体积，单位立方厘米, 精确到小数点后3位，会用于计抛 (是否计抛具体商务沟通中 双方约定)
     */
    private BigDecimal totalVolume;
    /**
     * 订单货物总重量（郑州空港海关必填）， 若为子母件必填， 单位千克， 精确到小数点后3位，如果提供此值， 必须>0 (子母件需>6)
     * condition
     */
    private BigDecimal totalWeight;
    /**
     * 商品总净重
     */
    private BigDecimal totalNetWeight;
    /**
     * 要求上门取件开始时间， 格式： YYYY-MM-DD HH24:MM:SS， 示例： 2012-7-30 09:30:00 （预约单传预约截止时间，不赋值默认按当前时间下发，1小时内取件）
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH24:MM:SS")
    private Date sendStartTm;
    /**
     * 是否通过手持终端 通知顺丰收派 员上门收件，支持以下值： 1：要求 0：不要求
     * default:0
     */
    private Integer isDocall;
    /**
     * 是否返回签回单 （签单返还）的运单号， 支持以下值： 1：要求 0：不要求
     * default:0
     */
    private Integer isSignBack;
    /**
     * 客户参考编码：如客户原始订单号
     */
    private String custReferenceNo;
    /**
     * 温度范围类型，当 express_type为12 医药温控件 时必填，支持以下值： 1:冷藏 3：冷冻
     * condition
     */
    private Integer temperatureRange;
    /**
     * 订单平台类型 （对于平台类客户， 如果需要在订单中 区分订单来源， 则可使用此字段） 天猫:tmall， 拼多多：pinduoduo， 京东 : jd 等平台类型编码
     */
    private String orderSource;
    /**
     * 备注
     */
    private String remark;
    /**
     * 快件自取，支持以下值： 1：客户同意快件自取 0：客户不同意快件自取
     * default 0
     */
    private Integer isOneselfPickup;
    /**
     * 筛单特殊字段用来人工筛单
     */
    private String filterField;
    /**
     * 是否返回用来退货业务的 二维码URL， 支持以下值： 1：返回二维码 0：不返回二维码
     */
    private Integer isReturnQRCode;
    /**
     * 当EXPRESS_TYPE=235 2：极效前置单（当日达） 5：极效前置小时达 当EXPRESS_TYPE=265 4：预售电标
     */
    private String specialDeliveryTypeCode;
    /**
     * 特殊派件具体表述 证件类型: 证件后8位如： 1:09296231（1 表示身份证， 暂不支持其他证件）
     */
    private String specialDeliveryValue;
    /**
     * 商户支付订单号
     */
    private String merchantPayOrderNo;
    /**
     * 是否返回签回单路由标签： 默认0， 1：返回路由标签， 0：不返回
     * default: 0
     */
    private Integer isReturnSignBackRoutelabel;
    /**
     * 是否返回路由标签： 默认1， 1：返回路由标签， 0：不返回；除部分特殊用户外，其余用户都默认返回
     * default: 1
     */
    private Integer isReturnRoutelabel;
    /**
     * 是否使用国家统一面单号 1：是， 0：否（默认）
     * default: 0
     */
    private Integer isUnifiedWaybillNo;
    /**
     * 签单返还范本地址
     */
    private String podModelAddress;
    /**
     * 头程运单号（郑州空港海关必填）
     */
    private String inProcessWaybillNo;
    /**
     * 是否需求分配运单号1：分配 0：不分配（若带单号下单，请传值0）
     * default: 1
     */
    private Integer isGenWaybillNo;
}
