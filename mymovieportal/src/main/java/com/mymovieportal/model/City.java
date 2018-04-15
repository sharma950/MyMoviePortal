package com.mymovieportal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class City.
 */
@Entity
@Table(name = "city")
public class City {

    /** The city id. */
    @Id
    @Column(name = "city_id")
    private String cityId;

    /** The city name. */
    @Column(name = "city_name")
    private String cityName;

    @Column(name = "city_status")
    private String cityStatus;

    /**
     * Gets the city id.
     *
     * @return the city id
     */
    public String getCityId() {
        return cityId;
    }

    /**
     * Sets the city id.
     *
     * @param cityId the new city id
     */
    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    /**
     * Gets the city name.
     *
     * @return the city name
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * Sets the city name.
     *
     * @param cityName the new city name
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }



    public String getCityStatus() {
        return cityStatus;
    }

    public void setCityStatus(String cityStatus) {
        this.cityStatus = cityStatus;
    }

    /**
     * Instantiates a new city.
     */
    public City() {
        super();
        // TODO Auto-generated constructor stub
    }

}
