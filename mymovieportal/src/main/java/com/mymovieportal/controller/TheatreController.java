package com.mymovieportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mymovieportal.model.Theatre;
import com.mymovieportal.service.TheatreService;

@RestController
@RequestMapping("/mymovieportal/theatre")
public class TheatreController {

    @Autowired
    TheatreService theatreService;

    @RequestMapping(value = "/getTheatre/{theatreId}", method = RequestMethod.GET)
    public ResponseEntity<Theatre> get(@PathVariable("theatreId") String theatreId) {
        Theatre theatre = theatreService.getTheatre(theatreId);
        if (theatre != null) {
            return ResponseEntity.ok().body(theatre);
        } else {
            Theatre theatre1 = new Theatre();
            return ResponseEntity.ok().body(theatre1);
        }

    }

    @RequestMapping(value = "/getTheatres", method = RequestMethod.GET)
    public @ResponseBody List<Theatre> getTheatres() {

        List<Theatre> TheatreList = theatreService.getTheatres();
        return TheatreList;
    }

    @RequestMapping(value = "/getTheatres/{cityId}", method = RequestMethod.GET)
    public @ResponseBody List<Theatre> getTheatresByCity(@PathVariable("cityId") String cityId) {

        List<Theatre> TheatreList = theatreService.getTheatresByCity(cityId);
        return TheatreList;
    }
}
