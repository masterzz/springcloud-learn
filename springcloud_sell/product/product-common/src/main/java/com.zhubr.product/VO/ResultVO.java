package com.zhubr.product.VO;

import lombok.Data;

/**
 * http请求返回的是最外层对象
 * @param <T>
 */
@Data
public class ResultVO<T> {
    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体内容
     */
    private T data;
}
