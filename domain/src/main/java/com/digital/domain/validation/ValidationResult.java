package com.digital.domain.validation;

import java.util.ArrayList;
import java.util.List;


/**
 * @author jiayin.wang
 * @date 2017-07-31
 */
public class ValidationResult
{
	private Boolean pass = Boolean.TRUE;
	private final List<String> msgs = new ArrayList<String>();

	public Boolean getPass()
	{
		return pass;
	}

	public void setPass(final Boolean pass)
	{
		this.pass = pass;
	}

	public List<String> getMsgs()
	{
		return msgs;
	}

	public void addMsg(final String msg)
	{
		this.msgs.add(msg);
	}

}
