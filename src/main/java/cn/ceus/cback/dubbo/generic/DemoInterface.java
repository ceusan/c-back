package cn.ceus.cback.dubbo.generic;

import cn.ceus.cback.dubbo.generic.dto.ApiResult;

public interface DemoInterface {

    ApiResult<UserResDto> queryUser(UserReqDto userReqDto);

}
