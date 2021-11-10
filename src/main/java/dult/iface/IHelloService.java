package dult.iface;

import dult.FullLogConfiguration;
import dult.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 参数绑定测试
 * Created by dult on 2021-11-9.
 */
@FeignClient(value = "hello-service",fallback = HelloServiceFallback.class,configuration = FullLogConfiguration.class)
public interface IHelloService {
    @RequestMapping("/hello")
    String hello();

    @RequestMapping(value = "/hello1",method = RequestMethod.GET)
    String hello(@RequestParam("name")String name);

    @RequestMapping(value = "/hello2",method = RequestMethod.GET)
    User hello(@RequestHeader("name")String name,@RequestHeader("age")Integer age);

    @RequestMapping(value = "/hello3",method = RequestMethod.POST)
    String hello(@RequestBody User user);
}
