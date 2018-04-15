package com.mymovieportal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class CityTheatre.
 */
@Entity
@Table(name = "citytheatre")
public class CityTheatre {

    /** The city theatre id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "citytheatre_id")
    private String cityTheatreId;

    /** The ct theatre id. */
    @Column(name = "ct_theatre_id")
    private String ctTheatreId;

    /** The ct city id. */
    @Column(name = "ct_city_id")
    private String ctCityId;

    /**
     * Gets the city theatre id.
     *
     * @return the city theatre id
     */
    public String getCityTheatreId() {
        return cityTheatreId;
    }

    /**
     * Sets the city theatre id.
     *
     * @param cityTheatreId the new city theatre id
     */
    public void setCityTheatreId(String cityTheatreId) {
        this.cityTheatreId = cityTheatreId;
    }

    /**
     * Gets the ct theatre id.
     *
     * @return the ct theatre id
     */
    public String getCtTheatreId() {
        return ctTheatreId;
    }

    /**
     * Sets the ct theatre id.
     *
     * @param ctTheatreId the new ct theatre id
     */
    public void setCtTheatreId(String ctTheatreId) {
        this.ctTheatreId = ctTheatreId;
    }

    /**
     * Gets the ct city id.
     *
     * @return the ct city id
     */
    public String getCtCityId() {
        return ctCityId;
    }

    /**
     * Sets the ct city id.
     *
     * @param ctCityId the new ct city id
     */
    public void setCtCityId(String ctCityId) {
        this.ctCityId = ctCityId;
    }

}
