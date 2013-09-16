package com.duan.beans; /**
 *
 */

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;
import java.util.List;

/**
 * @author Administrator
 *
 */
@XStreamAlias("family")
public class Family implements Serializable
{
	/**
	 *
	 */
	private static final long serialVersionUID = 2666558275262597117L;

	@XStreamAlias("phone")
	private String telephone;

	private List<Person> members;

	private String address;

//	@XStreamConverter(SportsConverter.class)
	private List<String> sports;

	public String getTelephone()
	{
		return telephone;
	}

	public void setTelephone(String telephone)
	{
		this.telephone = telephone;
	}

	public List<Person> getMembers()
	{
		return members;
	}

	public void setMembers(List<Person> members)
	{
		this.members = members;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public List<String> getSports()
	{
		return sports;
	}

	public void setSports(List<String> sports)
	{
		this.sports = sports;
	}

	@Override
	public String toString()
	{
		return "Family [address=" + address + ", members=" + members
				+ ", sports=" + sports + ", telephone=" + telephone + "]";
	}

}
