package com.mymovieportal.service;

import java.util.List;

import com.mymovieportal.model.Theatre;

public interface TheatreService {

    Theatre getTheatre(String theatreId);

    List<Theatre> getTheatres();

    List<Theatre> getTheatresByCity(String cityId);
}
