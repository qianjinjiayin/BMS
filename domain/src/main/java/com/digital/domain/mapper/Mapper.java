package com.digital.domain.mapper;

/**
* @author jiayin.wang
* @date 2017-07-31
*/
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


public class Mapper
{
	private final org.dozer.Mapper dozerBeanMapper;

	Mapper(final org.dozer.Mapper dozerBeanMapper)
	{
		this.dozerBeanMapper = dozerBeanMapper;
	}

	public void map(final Object source, final Object destination)
	{
		this.dozerBeanMapper.map(source, destination);
	}

	public <T> T map(final Object source, final Class<T> destinationClass)
	{
		return this.dozerBeanMapper.map(source, destinationClass);
	}

	public <T> List<T> map(final Collection<?> sources, final Class<T> destinationClass)
	{
		final List destinations = new ArrayList();
		for (final Iterator i$ = sources.iterator(); i$.hasNext();)
		{
			final Object source = i$.next();

			destinations.add(map(source, destinationClass));
		}
		return destinations;
	}
}
