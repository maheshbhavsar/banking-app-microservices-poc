package com.techprimers.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.india.cloud.demo.feignClients.HelloResourceClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/rest/hello/client")
@RefreshScope
public class HelloResource {

	@Autowired
	HelloResourceClient helloResourceClient;

	@HystrixCommand(fallbackMethod = "fallback", groupKey = "Hello",
            commandKey = "hello",
            threadPoolKey = "helloThread"
            )
    @GetMapping
    public String hello() { 
    return helloResourceClient.hello();	
    }

    public String fallback(Throwable hystrixCommand) {
        return "Fall Back Hello world";
    }

}
