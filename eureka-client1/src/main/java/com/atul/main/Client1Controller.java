package com.atul.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;


@RestController
public class Client1Controller {
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@GetMapping("/client1")
	public String getClient2() {
		List<ServiceInstance> serviceInstance = discoveryClient.getInstances("eurekaclient2");
		String newUrl = serviceInstance.get(0).getUri().toString()+"/client2";
		System.out.println(newUrl);
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.getForObject(newUrl, String.class);
		return response;		
	}

}
