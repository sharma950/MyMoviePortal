package com.mymovieportal.dao;

import java.util.List;

import com.mymovieportal.model.Theatre;

public interface TheatreDAO {

    Theatre getTheatre(String theatreId);

    List<Theatre> getTheatres();

    List<Theatre> getTheatresByCity(String cityId);
}
