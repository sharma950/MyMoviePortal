package com.mymovieportal.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Showtime.
 */
@Entity
@Table(name = "showtime")
public class Showtime {

	/** The show time id. */
	@Id
	@Column(name = "showtime_id")
	private String showTimeId;

	/** The show time value. */
	@Column(name = "showtime_name")
	private Date showTimeValue;

	/**
	 * Instantiates a new showtime.
	 */
	public Showtime() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Gets the show time id.
	 *
	 * @return the show time id
	 */
	public String getShowTimeId() {
		return showTimeId;
	}

	/**
	 * Sets the show time id.
	 *
	 * @param showTimeId
	 *            the new show time id
	 */
	public void setShowTimeId(String showTimeId) {
		this.showTimeId = showTimeId;
	}

	/**
	 * Gets the show time value.
	 *
	 * @return the show time value
	 */
	public Date getShowTimeValue() {
		return showTimeValue;
	}

	/**
	 * Sets the show time value.
	 *
	 * @param showTimeName
	 *            the new show time value
	 */
	public void setShowTimeValue(Date showTimeName) {
		this.showTimeValue = showTimeName;
	}

}
