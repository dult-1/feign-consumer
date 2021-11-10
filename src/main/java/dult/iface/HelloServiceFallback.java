package dult.iface;

import dult.pojo.User;
import org.springframework.stereotype.Component;

/**
 * Created by dult on 2021-11-10.
 */
@Component
public class HelloServiceFallback implements IHelloService {

    @Override
    public String hello() {
        return "error";
    }

    @Override
    public String hello(String name) {
        return "error";
    }

    @Override
    public User hello(String name, Integer age) {
        return new User("未知",0);
    }

    @Override
    public String hello(User user) {
        return "error";
    }
}
