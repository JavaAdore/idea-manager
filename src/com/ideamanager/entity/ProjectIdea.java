package com.ideamanager.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.general.utils.Marker;

@Entity
public class ProjectIdea implements Marker, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long ID;

	private String title;
	private String description;
	private String aims;
	private String academicQuestion;
	private Date submissionDate;
	private Integer numberOfStudents;

	@OneToOne()
	@JoinColumn(name = "OWNER_ID", referencedColumnName = "ID", unique = true)
	private Person ideaOwner;

	@ManyToOne
	@JoinColumn(name="STATUS_ID" , referencedColumnName="ID")
	private IdeaStatus ideaStatus;
	
	@ManyToOne
	@JoinColumn(name="PROJECT_IDEA_ID" , referencedColumnName="ID")
	private IdeaStatus IdeaKind;
	
	
	
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
		ProjectIdea other = (ProjectIdea) obj;
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
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAims() {
		return aims;
	}

	public void setAims(String aims) {
		this.aims = aims;
	}

	public String getAcademicQuestion() {
		return academicQuestion;
	}

	public void setAcademicQuestion(String academicQuestion) {
		this.academicQuestion = academicQuestion;
	}

	public Date getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}

	public Integer getNumberOfStudents() {
		return numberOfStudents;
	}

	public void setNumberOfStudents(Integer numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}

	public Person getIdeaOwner() {
		return ideaOwner;
	}

	public void setIdeaOwner(Person ideaOwner) {
		this.ideaOwner = ideaOwner;
	}



}
