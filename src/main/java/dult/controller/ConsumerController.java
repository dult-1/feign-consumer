package dult.controller;

import dult.iface.IHelloService;
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
    @RequestMapping("feign-consumer")
    public String helloConsumer(){
        return helloService.hello();
    }

    @RequestMapping("feign-consumer2")
    public String helloConsumer2(){
        StringBuilder sb = new StringBuilder();
        sb.append(helloService.hello()).append("\n");
        sb.append(helloService.hello("dult")).append("\n");
        sb.append(helloService.hello("dult",30)).append("\n");
        sb.append(helloService.hello(new User("dult",30))).append("\n");
        return sb.toString();
    }
}
