package com.ideamanager.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.general.utils.Marker;

@Entity
public class Suspension implements Marker , Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long ID;
	
	private String reason;
	
	@ManyToOne()
	@JoinColumn(name="OWNER_ID", referencedColumnName="ID",unique=true)
	private Person suspensionOwner;
	
	@Column(name="SUSPENSION_DATE")
	private Date suspensionDate;
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Suspension other = (Suspension) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		return true;
	}
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	

	
	public Person getSuspensionOwner() {
		return suspensionOwner;
	}
	public void setSuspensionOwner(Person suspensionOwner) {
		this.suspensionOwner = suspensionOwner;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Date getSuspensionDate() {
		return suspensionDate;
	}
	public void setSuspensionDate(Date suspensionDate) {
		this.suspensionDate = suspensionDate;
	}
	
	
	
	

}
