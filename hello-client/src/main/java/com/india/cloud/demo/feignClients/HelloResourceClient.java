package com.india.cloud.demo.feignClients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient(name="hello-server" )
public interface HelloResourceClient {

	 @RequestMapping("/rest/hello/server")
	 public String hello();
}
