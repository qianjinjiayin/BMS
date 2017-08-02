package com.digital.model.state;

/**
 * @author jiayin.wang
 * @date 2017-07-31
 */
public enum UserInfoState
{
	REGISTERED("RGS"), UPDATED("UPD"), CANCELLED("CAN");

	private final String code;

	private UserInfoState(final String code)
	{
		this.code = code;
	}

	public String getCode()
	{
		return code;
	}

	public static UserInfoState getInitialState()
	{
		return REGISTERED;
	}

	static UserInfoState fromCode(final String code)
	{
		for (final UserInfoState state : UserInfoState.values())
		{
			if (code == state.code || code.equals(state.code))
			{
				return state;
			}
		}
		return null;
	}

}
