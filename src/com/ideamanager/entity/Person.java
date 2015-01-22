package com.ideamanager.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.general.utils.Marker;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Person implements Marker , Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long ID;
	private String username;
	private String forname;
	private String surname;
	private String password;
	private Date dateCreation;
	private Date dateConfirmation;
	private Date lastLogin;
	
	@OneToMany(mappedBy="emailOwner")
	private List<Email> emails;
	
	@OneToMany(mappedBy="phoneOwner")
	private List<Phone> phones;
	
	@OneToMany(mappedBy="suspensionOwner")
	private List<Suspension> suspension;
	
	@OneToOne(mappedBy="statusOwner")
	private PersonStatus personStatus;
	
	@OneToOne(mappedBy="ideaOwner") 
	private ProjectIdea projectIdea; 
	
	
	
	
	@ManyToOne
	@JoinColumn(name="ORGANIZATION_ID",referencedColumnName="ID")
	private Organization organization;
	
	
	@OneToMany(mappedBy="changeInitiator")
	private List<ProjectIdeaHistory> projectIdeaHistory;

	
	
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getForname() {
		return forname;
	}
	public void setForname(String forname) {
		this.forname = forname;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Date getDateConfirmation() {
		return dateConfirmation;
	}
	public void setDateConfirmation(Date dateConfirmation) {
		this.dateConfirmation = dateConfirmation;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
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
		Person other = (Person) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		return true;
	}
	
	
	

}
