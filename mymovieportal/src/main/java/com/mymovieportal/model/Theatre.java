package com.mymovieportal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Theatre.
 */
@Entity
@Table(name = "theatre")
public class Theatre {

	/** The theatre id. */
	@Id
	@Column(name = "theatre_id")
	private String theatreId;

	/** The theatre name. */
	@Column(name = "theatre_name")
	private String theatreName;

	/**
	 * Instantiates a new theatre.
	 */
	public Theatre() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Gets the theatre id.
	 *
	 * @return the theatre id
	 */
	public String getTheatreId() {
		return theatreId;
	}

	/**
	 * Sets the theatre id.
	 *
	 * @param theatreId
	 *            the new theatre id
	 */
	public void setTheatreId(String theatreId) {
		this.theatreId = theatreId;
	}

	/**
	 * Gets the theatre name.
	 *
	 * @return the theatre name
	 */
	public String getTheatreName() {
		return theatreName;
	}

	/**
	 * Sets the theatre name.
	 *
	 * @param theatreName
	 *            the new theatre name
	 */
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

}
