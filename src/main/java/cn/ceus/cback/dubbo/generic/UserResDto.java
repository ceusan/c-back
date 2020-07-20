package cn.ceus.cback.dubbo.generic;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserResDto implements Serializable {

    private String fullName;
}
