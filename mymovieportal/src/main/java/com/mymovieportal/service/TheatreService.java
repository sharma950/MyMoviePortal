package com.mymovieportal.service;

import java.util.List;

import com.mymovieportal.dto.TheatreDTO;
import com.mymovieportal.model.Theatre;

// TODO: Auto-generated Javadoc
/**
 * The Interface TheatreService.
 */
public interface TheatreService {

    /**
     * Gets the theatre.
     *
     * @param theatreId the theatre id
     * @return the theatre
     */
    Theatre getTheatre(String theatreId);

    /**
     * Gets the theatres.
     *
     * @return the theatres
     */
    List<Theatre> getTheatres();

    /**
     * Gets the theare name only.
     *
     * @param theatreId the theatre id
     * @return the theare name only
     */
    String getTheareNameOnly(String theatreId);

    /**
     * Gets the theatres by city.
     *
     * @param cityId the city id
     * @return the theatres by city
     */
    List<Theatre> getTheatresByCity(String cityId);

    Theatre deleteTheatre(TheatreDTO theatreDTO);

    Theatre insertTheatre(TheatreDTO theatreDTO);

}
