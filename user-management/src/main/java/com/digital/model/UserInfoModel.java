package com.digital.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.digital.model.state.UserInfoState;
import com.digital.util.RandomUtil;


@Entity
@Table(name = "userinfo")
public class UserInfoModel
{
	@Id
	@GeneratedValue
	private long id;

	private String cardno;
	private String name;
	private String sex;
	private String address;
	private long postcode;
	private long phone;
	private String email;
	private String password;
	private String type;
	private long creditlevel;
	private String status;
	private Date createdate;
	private String createby;
	private Date modifydate;
	private String modifyby;

	public long getId()
	{
		return id;
	}

	public void setId(final long id)
	{
		this.id = id;
	}

	public String getCardno()
	{
		return cardno;
	}

	public void setCardno(final String cardno)
	{
		this.cardno = cardno;
	}

	public String getName()
	{
		return name;
	}

	public void setName(final String name)
	{
		this.name = name;
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

	public long getPostcode()
	{
		return postcode;
	}

	public void setPostcode(final long postcode)
	{
		this.postcode = postcode;
	}

	public long getPhone()
	{
		return phone;
	}

	public void setPhone(final long phone)
	{
		this.phone = phone;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(final String email)
	{
		this.email = email;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(final String password)
	{
		this.password = password;
	}

	public String getType()
	{
		return type;
	}

	public void setType(final String type)
	{
		this.type = type;
	}

	public long getCreditlevel()
	{
		return creditlevel;
	}

	public void setCreditlevel(final long creditlevel)
	{
		this.creditlevel = creditlevel;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(final String status)
	{
		this.status = status;
	}

	public Date getCreatedate()
	{
		return createdate;
	}

	public void setCreatedate(final Date createdate)
	{
		this.createdate = createdate;
	}

	public String getCreateby()
	{
		return createby;
	}

	public void setCreateby(final String createby)
	{
		this.createby = createby;
	}

	public Date getModifydate()
	{
		return modifydate;
	}

	public void setModifydate(final Date modifydate)
	{
		this.modifydate = modifydate;
	}

	public String getModifyby()
	{
		return modifyby;
	}

	public void setModifyby(final String modifyby)
	{
		this.modifyby = modifyby;
	}

	@Transient
	public void setInitialState()
	{
		this.status = UserInfoState.getInitialState().getCode();
	}

	@Transient
	public void registerUpdate()
	{
		this.status = UserInfoState.UPDATED.getCode();
	}

	@Transient
	public void setInitialCardNo()
	{
		this.cardno = RandomUtil.generate(10);
	}

	@Override
	@Transient
	public String toString()
	{
		final StringBuffer sb = new StringBuffer();
		sb.append("UserInfoModel==>>>[");
		sb.append("id=").append(id).append(",");
		sb.append("cardno=").append(cardno).append(",");
		sb.append("name=").append(name).append(",");
		sb.append("sex=").append(sex).append(",");
		sb.append("address=").append(address).append(",");
		sb.append("postcode=").append(postcode).append(",");
		sb.append("phone=").append(phone).append(",");
		sb.append("email=").append(email).append(",");
		sb.append("password=").append(password).append(",");
		sb.append("type=").append(type).append(",");
		sb.append("creditlevel=").append(creditlevel).append(",");
		sb.append("status=").append(status).append(",");
		sb.append("createdate=").append(createdate).append(",");
		sb.append("createby=").append(createby).append(",");
		sb.append("modifydate=").append(modifydate).append(",");
		sb.append("modifyby=").append(modifyby);
		sb.append("]");
		return sb.toString();
	}

}
