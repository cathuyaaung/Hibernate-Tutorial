package org.thomas.java.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table (name="USER_DETAILS")
public class UserDetails {
	
	@Id 
	@GenericGenerator(name = "increment-gen", strategy = "increment")
	@GeneratedValue(generator="increment-gen")
	private int userId;	
	
	private String userName;
	
	@Temporal (TemporalType.DATE)
	private Date userDOB;
	
	@Lob 
	private String userDesc;
	
	@ElementCollection (fetch=FetchType.EAGER)
	@JoinTable (name="USER_ADDRESSES",
			joinColumns=@JoinColumn(name="USER_ID"))
	private Collection<Address> listOfAddresses = new ArrayList<Address>();
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getUserDOB() {
		return userDOB;
	}
	public void setUserDOB(Date userDOB) {
		this.userDOB = userDOB;
	}
	public String getUserDesc() {
		return userDesc;
	}
	public void setUserDesc(String userDesc) {
		this.userDesc = userDesc;
	}
	public Collection<Address> getListOfAddresses() {
		return listOfAddresses;
	}
	public void setListOfAddresses(Collection<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}

}
