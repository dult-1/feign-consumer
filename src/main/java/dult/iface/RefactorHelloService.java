package dult.iface;

import dult.service.HelloService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 继承特性测试
 * Created by dult on 2021-11-10.
 */
@FeignClient("hello-service")
public interface RefactorHelloService extends HelloService {
}
