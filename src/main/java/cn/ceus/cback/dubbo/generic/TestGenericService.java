package cn.ceus.cback.dubbo.generic;

import cn.ceus.cback.dubbo.generic.dto.ApiResult;
import com.alibaba.dubbo.common.utils.PojoUtils;
import com.alibaba.dubbo.rpc.service.GenericException;
import com.alibaba.dubbo.rpc.service.GenericService;
import com.alibaba.fastjson.JSON;

public class TestGenericService implements GenericService {
    public Object $invoke(String methodName, String[] parameterTypes, Object[] args) throws GenericException {
        System.out.println("methodName:"+methodName);
        System.out.println("parameterTypes:"+parameterTypes);
        System.out.println("args:"+args);




        Object[] paramObj = new Object[parameterTypes.length];
        for(int i = 0;i<parameterTypes.length;i++){
            try {
                paramObj[i] =PojoUtils.realize(args[i],Class.forName(parameterTypes[i]));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        System.out.println(paramObj);


        ApiResult result = new ApiResult();
        result.setCode(0);
        result.setMessage("成功");
        UserResDto userResDto = new UserResDto();
        userResDto.setFullName("全名");
        result.setData(userResDto);
        String object = JSON.toJSONString(result);
        System.out.println(object);
        return object;
//        return "proxy success:"+methodName+"  "+parameterTypes[0]+ " "+ args[0];
    }
}
