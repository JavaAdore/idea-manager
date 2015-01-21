package com.ideamanager.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.general.utils.Marker;

@Entity
public class ProjectIdeaHistory implements Marker, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long ID;
	private Date date;
	private String change;
	private String reason;

	@ManyToOne()
	@JoinColumn(name = "CHANGE_INITIATOR_ID", referencedColumnName = "ID", unique = true)
	private Person changeInitiator;

	@OneToMany
	@JoinColumn(name = "PROJECT_IDEA_ID", referencedColumnName = "ID", unique = true)
	private ProjectIdea projectIdea;
	
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
		ProjectIdeaHistory other = (ProjectIdeaHistory) obj;
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


}
