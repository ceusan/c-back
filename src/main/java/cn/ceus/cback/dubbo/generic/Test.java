package cn.ceus.cback.dubbo.generic;

import cn.ceus.cback.dubbo.generic.dto.ApiResult;
import com.alibaba.dubbo.common.utils.PojoUtils;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void  main(String args[]){
        String[] parameterTypes = {"cn.ceus.cback.dubbo.generic.UserReqDto"};
        ApiResult<UserReqDto> ar = new ApiResult<>();
        UserReqDto urd = new UserReqDto();
        urd.setName("1");
        ar.setData(urd);
        ar.setMessage("成功");
        ar.setCode(0);
        System.out.println(PojoUtils.generalize(ar));
        Map map = new HashMap();
        map.put("name","test");
        map.put("class","cn.ceus.cback.dubbo.generic.UserReqDto");
        Object[] a = {map};
        UserReqDto bean = null;
        try {
            bean = (UserReqDto) PojoUtils.realize(map,Class.forName("cn.ceus.cback.dubbo.generic.UserReqDto"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(bean);
    }
}
