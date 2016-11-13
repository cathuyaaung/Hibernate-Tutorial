package org.thomas.java.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table (name="USER_DETAILS")
public class UserDetails {
	
	@Id 
	@GenericGenerator(name = "uuid-gen", strategy = "uuid")
	@GeneratedValue(generator="uuid-gen")
	private String userId;	
	private String userName;
	@Temporal (TemporalType.DATE)
	private Date userDOB;
	@Lob 
	private String userDesc;
	@ElementCollection
	@JoinTable (name="USER_ADDRESSES",
			joinColumns=@JoinColumn(name="USER_ID"))
	@GenericGenerator(name = "uuid-gen", strategy = "uuid")
	@CollectionId(columns = { @Column(name="ADDRESS_ID") }, generator = "uuid-gen", type = @Type(type="string"))
	private Collection<Address> listOfAddresses = new ArrayList<Address>();
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
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
