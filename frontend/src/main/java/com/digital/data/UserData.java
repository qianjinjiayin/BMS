package com.digital.data;

/**
 * @author jiayin.wang
 * @date 2017-07-27
 */
public class UserData
{
	private String name;
	private String pwd;

	public UserData()
	{

	}

	public UserData(final String name, final String pwd)
	{
		this.name = name;
		this.pwd = pwd;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(final String name)
	{
		this.name = name;
	}

	public String getPwd()
	{
		return this.pwd;
	}

	public void setPwd(final String pwd)
	{
		this.pwd = pwd;
	}

	@Override
	public String toString()
	{
		return "[name=" + name + "]" + ", " + "[pwd=" + pwd + "]";
	}
}
