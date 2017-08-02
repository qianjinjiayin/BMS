package com.digital.formData;

/**
 * @author jiayin.wang
 * @date 2017-07-31
 */
public class UserInfoForm
{
	private String id;
	private String username;
	private String password;
	private String confirmPassword;
	private String email;
	private String cardno;
	private String creditlevel;
	private String type = "customer";
	private String postcode;
	private String phone;
	private String sex;
	private String address;

	public String getId()
	{
		return id;
	}

	public void setId(final String id)
	{
		this.id = id;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(final String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(final String password)
	{
		this.password = password;
	}

	public String getConfirmPassword()
	{
		return confirmPassword;
	}

	public void setConfirmPassword(final String confirmPassword)
	{
		this.confirmPassword = confirmPassword;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(final String email)
	{
		this.email = email;
	}

	public String getCardno()
	{
		return cardno;
	}

	public void setCardno(final String cardno)
	{
		this.cardno = cardno;
	}

	public String getCreditlevel()
	{
		return creditlevel;
	}

	public void setCreditlevel(final String creditlevel)
	{
		this.creditlevel = creditlevel;
	}

	public String getType()
	{
		return type;
	}

	public void setType(final String type)
	{
		this.type = type;
	}

	public String getPostcode()
	{
		return postcode;
	}

	public void setPostcode(final String postcode)
	{
		this.postcode = postcode;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(final String phone)
	{
		this.phone = phone;
	}

	public String getSex()
	{
		return sex;
	}

	public void setSex(final String sex)
	{
		this.sex = sex;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(final String address)
	{
		this.address = address;
	}

	@Override
	public String toString()
	{
		final StringBuffer sb = new StringBuffer();
		sb.append("UserInfoForm [");
		sb.append("id=").append(id).append(", ");
		sb.append("username=").append(username).append(", ");
		sb.append("password=").append(password).append(", ");
		sb.append("confirmPassword=").append(confirmPassword).append(", ");
		sb.append("email=").append(email).append(", ");
		sb.append("cardno=").append(cardno).append(", ");
		sb.append("creditlevel=").append(creditlevel).append(", ");
		sb.append("type=").append(type).append(", ");
		sb.append("postcode=").append(postcode).append(", ");
		sb.append("phone=").append(phone).append(", ");
		sb.append("sex=").append(sex).append(", ");
		sb.append("address=").append(address);
		sb.append("]");
		return sb.toString();
	}


}
