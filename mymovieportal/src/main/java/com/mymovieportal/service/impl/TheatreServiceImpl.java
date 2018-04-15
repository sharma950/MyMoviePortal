package com.mymovieportal.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymovieportal.dto.TheatreDTO;
import com.mymovieportal.model.Theatre;
import com.mymovieportal.repository.TheatreRepository;
import com.mymovieportal.service.TheatreService;

// TODO: Auto-generated Javadoc
/**
 * The Class TheatreServiceImpl.
 */
@Service
public class TheatreServiceImpl implements TheatreService {

    /** The theatre repository. */
    @Autowired
    TheatreRepository theatreRepository;

    /**
     * Gets the theatre.
     *
     * @param theatreId the theatre id
     * @return the theatre
     */
    @Override
    @Transactional
    public Theatre getTheatre(String theatreId) {
        // TODO Auto-generated method stub
        Theatre theatre = theatreRepository.findByTheatreId(theatreId);
        return theatre;
    }

    /**
     * Gets the theatres.
     *
     * @return the theatres
     */
    @Override
    @Transactional
    public List<Theatre> getTheatres() {
        // TODO Auto-generated method stub
        return theatreRepository.getTheatres();
    }

    /**
     * Gets the theatres by city.
     *
     * @param cityId the city id
     * @return the theatres by city
     */

    @Override
    @Transactional
    public List<Theatre> getTheatresByCity(String cityId) {
        // TODO Auto-generated method stub
        return theatreRepository.getTheatresByCity(cityId);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.mymovieportal.service.TheatreService#getTheareNameOnly(java.lang.String)
     */
    @Override
    @Transactional
    public String getTheareNameOnly(String theatreId) {
        return theatreRepository.getTheatreNameOnly(theatreId);
    }


    @Override
    @Transactional
    public Theatre insertTheatre(TheatreDTO theatreDTO) {
        // TODO Auto-generated method stub
        List<String> theatreIds = theatreRepository.getTheatreIds();
        String id = theatreIds.get(theatreIds.size() - 1);
        String ch = "t";
        id = id.substring(1);
        int theatreId = Integer.parseInt(id);
        if (theatreId < 9) {
            ch += "0";
        }
        theatreId++;

        Theatre theatre = new Theatre();
        theatre.setTheatreName(theatreDTO.getTheatreName());
        theatre.setTheatreId(ch + theatreId);
        theatre.setTheatreStatus("active");
        Theatre response = theatreRepository.save(theatre);
        return response;

    }

    @Override
    @Transactional
    public Theatre deleteTheatre(TheatreDTO theatreDTO) {
        // TODO Auto-generated method stub

        Theatre theatre = theatreRepository.findByTheatreNameAndTheatreStatus(theatreDTO.getTheatreName(), "active");
        if (theatre == null) {
            return theatre;
        }
        theatre.setTheatreName(theatre.getTheatreName());
        theatre.setTheatreStatus("inactive");
        theatre.setTheatreId(theatre.getTheatreId());
        Theatre response = theatreRepository.save(theatre);
        return response;

    }
}
