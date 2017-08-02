package com.digital.util;

/**
* @author jiayin.wang
* @date 2017-07-31
*/
import java.util.Random;


public class RandomUtil
{
	private static final String ALLCHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	private static final Random random = new Random(System.currentTimeMillis());

	public static String generate(final int length)
	{
		final StringBuffer sb = new StringBuffer();

		for (int i = 0; i < length; i++)
		{
			sb.append(ALLCHAR.charAt(random.nextInt(ALLCHAR.length())));
		}
		return sb.toString();
	}
}
