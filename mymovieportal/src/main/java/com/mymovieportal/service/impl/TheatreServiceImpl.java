package com.mymovieportal.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymovieportal.dao.TheatreDAO;
import com.mymovieportal.model.Theatre;
import com.mymovieportal.service.TheatreService;

@Service
public class TheatreServiceImpl implements TheatreService{

    @Autowired
    TheatreDAO theatreDao;
    @Override
    @Transactional
    public Theatre getTheatre(String theatreId) {
        // TODO Auto-generated method stub
        return theatreDao.getTheatre(theatreId);
    }

    @Override
    @Transactional
    public List<Theatre> getTheatres() {
        // TODO Auto-generated method stub
        return theatreDao.getTheatres();
    }

    @Override
    @Transactional
    public List<Theatre> getTheatresByCity(String cityId) {
        // TODO Auto-generated method stub
        return theatreDao.getTheatresByCity(cityId);
    }

}
