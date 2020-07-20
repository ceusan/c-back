package cn.ceus.cback.dubbo.generic.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ApiResult<D> implements Serializable {

    /**
     * 编码(可表示错误码等)。
     */
    private int code;
    /**
     * 错误信息编码(可表示错误码等)。
     */
    private String message;
    /**
     * 数据。
     */
    private D data;
}
