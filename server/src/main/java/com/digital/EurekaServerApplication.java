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
public class EurekaServerApplication
{

	public static void main(final String[] args)
	{
		new SpringApplicationBuilder(EurekaServerApplication.class).web(true).run(args);
	}

}
