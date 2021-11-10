package dult.controller;

import dult.iface.IHelloService;
import dult.iface.RefactorHelloService;
import dult.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dult on 2021-11-9.
 */
@RestController
public class ConsumerController {
    @Autowired
    IHelloService helloService;
    @Autowired
    RefactorHelloService refactorHelloService;

    @RequestMapping("feign-consumer")
    public String helloConsumer(){
        return helloService.hello();
    }

    /**
     * 测试参数绑定
     * @return
     */
    @RequestMapping("feign-consumer2")
    public String helloConsumer2(){
        StringBuilder sb = new StringBuilder();
        sb.append(helloService.hello()).append("\n");
        sb.append(helloService.hello("dult")).append("\n");
        sb.append(helloService.hello("dult",30)).append("\n");
        sb.append(helloService.hello(new User("dult",30))).append("\n");
        System.out.println(sb.toString());
        return sb.toString();
    }

    /**
     * 测试继承特性
     * @return
     */
    @RequestMapping("feign-consumer3")
    public String helloConsumer3(){
        StringBuilder sb = new StringBuilder();
        sb.append(refactorHelloService.hello("dult")).append("\n");
        sb.append(refactorHelloService.hello("dult",30)).append("\n");
        sb.append(refactorHelloService.hello(new dult.dto.User("dult",30))).append("\n");
        System.out.println(sb.toString());
        return sb.toString();
    }
}
