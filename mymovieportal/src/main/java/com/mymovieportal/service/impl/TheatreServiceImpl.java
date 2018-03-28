package com.mymovieportal.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymovieportal.dao.TheatreDAO;
import com.mymovieportal.model.Theatre;
import com.mymovieportal.repository.TheatreRepository;
import com.mymovieportal.service.TheatreService;

@Service
public class TheatreServiceImpl implements TheatreService{

    @Autowired 
    TheatreRepository theatreRepository;
    
    @Override
    @Transactional
    public Theatre getTheatre(String theatreId) {
        // TODO Auto-generated method stub
    	Theatre theatre = theatreRepository.findByTheatreId(theatreId);
        return theatre;
    }

    @Override
    @Transactional
    public List<Theatre> getTheatres() {
        // TODO Auto-generated method stub
    	List<Theatre> theatreList = theatreRepository.findAll();
        return theatreList;
    }

    @Override
    @Transactional
    public List<Theatre> getTheatresByCity(String cityId) {
        // TODO Auto-generated method stub
    	List<Theatre> theatreList = theatreRepository.findByCityId(cityId);
        return theatreList;
    }

}
