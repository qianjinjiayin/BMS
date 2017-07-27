package com.digital.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.UrlPathHelper;

import com.digital.data.UserData;
import com.digital.service.SessionService;


/**
 * @author jiayin.wang
 * @date 2017-07-27
 */
@WebFilter(filterName = "bmsFilter", urlPatterns = "/*")
public class BMSFilter extends OncePerRequestFilter
{
	private static final String[] STATIC_RESOURCE_SUFFIX =
	{ ".css", ".js", ".jpg" };

	private static final Set<String> EXCLUSIVE_URL = new HashSet<String>(Arrays.asList("/", "/login"));

	@Resource
	private UrlPathHelper urlPathHelper;
	@Resource(name = "defaultSessionService")
	private SessionService sessionService;

	@Override
	protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response,
			final FilterChain filterChain) throws ServletException, IOException
	{
		final String servletPath = urlPathHelper.getServletPath(request);
		if (!isExclusivePath(servletPath) && !isStaticResources(servletPath))
		{
			final UserData user = sessionService.getCurrentUser();
			if (user == null)
			{
				response.sendRedirect("/");
				return;
			}
		}

		filterChain.doFilter(request, response);
	}

	private boolean isExclusivePath(final String servletPath)
	{
		if (EXCLUSIVE_URL.contains(servletPath))
		{
			return true;
		}
		return false;
	}

	private boolean isStaticResources(final String servletPath)
	{
		for (final String suffix : STATIC_RESOURCE_SUFFIX)
		{
			if (StringUtils.endsWithIgnoreCase(servletPath, suffix))
			{
				return true;
			}
		}
		return false;
	}

}
