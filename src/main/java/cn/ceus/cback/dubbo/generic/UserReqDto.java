package cn.ceus.cback.dubbo.generic;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserReqDto implements Serializable {

    private String name;
}
