package com.shcepp.memberserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
/**
 * @Author: Justin
 * @Date: 2018/6/4 17:09
 * @Description:  
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MemberServerApplication {

	/**
	 * @Author: Justin
	 * @Date: 2018/6/4 17:09
	 * @Description:  
	 */
	public static void main(String[] args) {
		SpringApplication.run(MemberServerApplication.class, args);
	}
}
