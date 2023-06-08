package com.coolk1ng.sf.order;

import lombok.Data;

/**
 * 增值服务信息，支持附录： 《增值服务产品表》
 *
 * @author coolk1ng
 * @since 2023/5/19 10:08
 */
@Data
public class Service {
    /**
     * 增值服务名，如COD等，支持附录： 《增值服务产品表》
     */
    private String name;
    /**
     * 	增值服务扩展属性，参考增值 服务传值说明
     */
    private String value;
    /**
     * 增值服务扩展属性1
     */
    private String value1;
    /**
     * 增值服务扩展属性2
     */
    private String value2;
    /**
     * 增值服务扩展属性3
     */
    private String value3;
    /**
     * 增值服务扩展属性4
     */
    private String value4;
}
