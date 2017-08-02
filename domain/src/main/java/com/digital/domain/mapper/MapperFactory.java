package com.digital.domain.mapper;

/**
* @author jiayin.wang
* @date 2017-07-31
*/
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import org.dozer.DozerBeanMapper;


public class MapperFactory
{
	private static Mapper instance;

	public static Mapper getMapper()
	{
		return instance;
	}

	static
	{
		try
		{
			final Enumeration urls = MapperFactory.class.getClassLoader().getResources("dozerBeanMapping.xml");
			final List mappingFileUrls = new ArrayList();
			while (urls.hasMoreElements())
			{
				final URL url = (URL) urls.nextElement();
				mappingFileUrls.add(url.toString());
			}
			instance = new Mapper(new DozerBeanMapper(mappingFileUrls));
		}
		catch (final IOException e)
		{
			throw new RuntimeException("Dozer initialization failed", e);
		}
	}
}
