package com.digital;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


/**
 * @author jiayin.wang
 * @date 2017-07-26
 */
@EnableZuulProxy
@SpringCloudApplication
public class GatewayApplication
{
	public static void main(final String[] args)
	{
		new SpringApplicationBuilder(GatewayApplication.class).web(true).run(args);
	}
}
