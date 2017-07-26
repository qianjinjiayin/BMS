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
public class BookManagementApplication
{

	public static void main(final String[] args)
	{
		new SpringApplicationBuilder(BookManagementApplication.class).web(true).run(args);
	}

}
