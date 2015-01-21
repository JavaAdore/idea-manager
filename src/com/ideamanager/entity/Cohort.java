package com.ideamanager.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.general.utils.Marker;

@Entity
public class Cohort implements Marker, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long ID;
	private String Title;
	private Date RegisterStart;
	private Date RegisterStop;
	private Date ProjectStart;
	private Date ProjectStop;
	
	

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
		Cohort other = (Cohort) obj;
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

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public Date getRegisterStart() {
		return RegisterStart;
	}

	public void setRegisterStart(Date registerStart) {
		RegisterStart = registerStart;
	}

	public Date getRegisterStop() {
		return RegisterStop;
	}

	public void setRegisterStop(Date registerStop) {
		RegisterStop = registerStop;
	}

	public Date getProjectStart() {
		return ProjectStart;
	}

	public void setProjectStart(Date projectStart) {
		ProjectStart = projectStart;
	}

	public Date getProjectStop() {
		return ProjectStop;
	}

	public void setProjectStop(Date projectStop) {
		ProjectStop = projectStop;
	}

}
