package cn.ceus.cback.dubbo.generic;

import com.alibaba.dubbo.config.*;
import com.alibaba.dubbo.rpc.service.GenericService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@Configuration
public class DubboProvider {

    public static void startWithExport(List<JSONObject> list) throws InterruptedException {

        GenericService genericService=new TestGenericService();
        ApplicationConfig applicationConfig = new ApplicationConfig("test-dubbo-provider");
        RegistryConfig registry=new RegistryConfig("zookeeper://127.0.0.1:2181");
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20882);
        for (JSONObject json:list) {
        ServiceConfig<GenericService> service = new ServiceConfig<>();
        service.setApplication(applicationConfig);
        service.setRegistry(registry);
            service.setInterface(json.getString("service"));
            service.setRef(genericService);
            service.setProtocol(protocolConfig);
            //配置每一个method的信息
            MethodConfig methodConfig = new MethodConfig();
            methodConfig.setName(json.getString("method"));
            methodConfig.setTimeout(1000);

            //将method的设置关联到service配置中
            List<MethodConfig> methods = new ArrayList<>();
            methods.add(methodConfig);
            service.setMethods(methods);
            service.setVersion(json.getString("version"));
//            service.setFilter("paramFilter");
            service.export();
        }
        System.out.println("dubbo service started");
        new CountDownLatch(1).await();
    }
    public static void main(String[] args) throws Exception {
        List list = new ArrayList<>();

        JSONObject json=new JSONObject();
        json.put("service","cn.ceus.cback.dubbo.generic.DemoInterface");
        json.put("method","queryUser");
        json.put("version","1.0.0");
        list.add(json);
//        JSONObject json1=new JSONObject();
//        json1.put("service","first-biz.test1");
//        json1.put("method","pay1");
//        json1.put("version","1.0.2");
//        list.add(json1);
//
//        JSONObject json2=new JSONObject();
//        json2.put("service","first-biz.test1");
//        json2.put("method","pay2");
//        json2.put("version","1.0.0");
//        list.add(json2);
//
//        JSONObject json3=new JSONObject();
//        json3.put("service","first-biz.test3");
//        json3.put("method","pay3");
//        json3.put("version","1.0.0");
//        list.add(json3);
        startWithExport(list);
    }
}
