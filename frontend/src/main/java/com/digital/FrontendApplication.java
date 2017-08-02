package com.digital;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;


/**
 * @author jiayin.wang
 * @date 2017-07-26
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@ServletComponentScan
public class FrontendApplication
{

	public static void main(final String[] args)
	{
		new SpringApplicationBuilder(FrontendApplication.class).web(true).run(args);
	}

}
