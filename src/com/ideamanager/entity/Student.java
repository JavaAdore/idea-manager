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


public class Student extends Person implements Marker , Serializable
{
	
	private static final long serialVersionUID = 1L;
	

	private String hemis;
	
	
	
	

	
	
	

}
