package com.digital;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


/**
 * @author jiayin.wang
 * @date 2017-07-26
 */
@EnableEurekaServer
@SpringBootApplication
public class BMSEurekaServerApplication
{

	public static void main(final String[] args)
	{
		new SpringApplicationBuilder(BMSEurekaServerApplication.class).web(true).run(args);
	}

}
