package com.digital;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;


/**
 * @author jiayin.wang
 * @date 2017-07-26
 */
@Component
public class AccessFilter extends ZuulFilter
{

	private static Logger log = LoggerFactory.getLogger(AccessFilter.class);

	@Override
	public String filterType()
	{
		return "pre";
	}

	@Override
	public int filterOrder()
	{
		return 0;
	}

	@Override
	public boolean shouldFilter()
	{
		return false;
	}

	@Override
	public Object run()
	{
		final RequestContext ctx = RequestContext.getCurrentContext();
		final HttpServletRequest request = ctx.getRequest();

		log.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());

		final Object accessToken = request.getParameter("accessToken");
		if (accessToken == null)
		{
			log.warn("access token is empty");
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			return null;
		}
		log.info("access token ok");
		return null;
	}

}
