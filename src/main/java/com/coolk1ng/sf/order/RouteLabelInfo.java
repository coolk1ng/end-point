package com.coolk1ng.sf.order;

import lombok.Data;

import java.util.List;

/**
 * 路由标签，除少量特殊场景用户外，其余均会返回
 *
 * @author coolk1ng
 * @since 2023/5/19 13:14
 */
@Data
public class RouteLabelInfo {
    /**
     * 返回调用结果，1000：调用成功； 其他调用失败
     */
    private String code;
    /**
     * 路由标签数据详细数据，除少量特殊场景用户外，其余均会返回
     */
    private List<RouteLabelData> routeLabelData;
    /**
     * 失败异常描述
     */
    private String message;
}
