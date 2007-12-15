package com.kirolak;

// Generated 30-nov-2007 8:26:55 by Hibernate Tools 3.2.0.CR1

import java.util.Date;

/**
 * Round generated by hbm2java
 */
public class Round implements java.io.Serializable {

	private RoundId id;
	private Date day;

	public Round() {
	}

	public Round(RoundId id) {
		this.id = id;
	}

	public Round(RoundId id, Date day) {
		this.id = id;
		this.day = day;
	}

	public RoundId getId() {
		return this.id;
	}

	public void setId(RoundId id) {
		this.id = id;
	}

	public Date getDay() {
		return this.day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

}