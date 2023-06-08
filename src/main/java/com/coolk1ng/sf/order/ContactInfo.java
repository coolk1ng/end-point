package com.coolk1ng.sf.order;

import lombok.Data;

/**
 * 收寄双方信息
 *
 * @author coolk1ng
 * @since 2023/5/19 10:08
 */
@Data
public class ContactInfo {
    /**
     * 地址类型： 1，寄件方信息 2，到件方信息
     * required
     */
    private Integer contactType;
    /**
     * 公司名称
     */
    private String company;
    /**
     * 联系人
     */
    private String contact;
    /**
     * 联系电话（tel和mobile字段必填其中一个）
     */
    private String tel;
    /**
     * 手机（tel和mobile字段必填其中一个）
     */
    private String mobile;
    /**
     * 城市代码,参考附录 《城市代码表》，如果是跨境件，则此字段为必填
     */
    private String zoneCode;
    /**
     * 国家或地区2位代码 参照附录《城市代码表》
     */
    private String country;
    /**
     * 所在省级行政区名称，必须是标准的省级行政区名称如：北 京、广东省、广西壮族自治区等；此字段影响原寄地代码识 别，建议尽可能传该字段的值
     */
    private String province;
    /**
     * 所在地级行政区名称，必须是标准的城市称谓 如：北京市、 深圳市、大理白族自治州等； 此字段影响原寄地代码识别， 建议尽可能传该字段的值
     */
    private String city;
    /**
     * 所在县/区级行政区名称，必须 是标准的县/区称谓，如：福田区，南涧彝族自治县、准格尔旗等
     */
    private String county;
    /**
     * 详细地址，若有四级行政区划，如镇/街道等信息可拼接至此字段，格式样例：镇/街道+详细地址。若province/city 字段的值不传，
     * 此字段必须包含省市信息，避免影响原寄地代码识别，如：广东省深圳市福田区新洲十一街万基商务大厦10楼；此字段地址必须详细，否则会影响目的地中转识别；
     */
    private String address;
    /**
     * 邮编，跨境件必填（中国内地， 港澳台互寄除外）
     */
    private String postCode;
    /**
     * 邮箱地址
     */
    private String email;
    /**
     * 税号
     */
    private String taxNo;
}
