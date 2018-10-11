package com.mxz.eureka.provider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Autowired
	private DiscoveryClient discoveryClient;    

	@ResponseBody
	@GetMapping("/provider/discovery")
	public Object discovery(){
	        List<String> list = discoveryClient.getServices();
	        System.out.println(list);
	        List<ServiceInstance> insList = discoveryClient.getInstances("eureka-server");
	        for (ServiceInstance si:insList) {
	            System.out.println(si.getHost() +"," + si.getServiceId() +"," +si.getPort() +"," +si.getUri() +"," +si.getMetadata());
	        }
	        return this.discoveryClient;
	    }
}
