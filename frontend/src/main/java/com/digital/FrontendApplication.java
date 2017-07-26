package com.digital;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * @author jiayin.wang
 * @date 2017-07-26
 */
@EnableDiscoveryClient
@SpringBootApplication
public class FrontendApplication
{

	public static void main(final String[] args)
	{
		new SpringApplicationBuilder(FrontendApplication.class).web(true).run(args);
	}

}
