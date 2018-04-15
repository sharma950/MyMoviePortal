package com.mymovieportal.mymovieportal.serviceImpl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mymovieportal.model.Theatre;
import com.mymovieportal.repository.TheatreRepository;
import com.mymovieportal.service.TheatreService;
import com.mymovieportal.service.impl.TheatreServiceImpl;

public class TheatreServiceImplUnitTest {

    @InjectMocks
    TheatreService theatreService = new TheatreServiceImpl();

    @Mock
    TheatreRepository theatreRepository;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetTheatre() {
        Theatre theatre = new Theatre();
        theatre.setTheatreId("t01");
        theatre.setTheatreName("Inox");

        when(theatreRepository.findByTheatreId(anyString())).thenReturn(theatre);
        Theatre theatre2 = theatreService.getTheatre("t01");

        assertSame(theatre.getTheatreId(), theatre2.getTheatreId());

    }

    @Test
    public void testGetTheatreInvalid() {
        Theatre theatre = new Theatre();

        when(theatreRepository.findByTheatreId(anyString())).thenReturn(theatre);
        Theatre theatre2 = theatreService.getTheatre("00");

        assertNull(theatre2.getTheatreId());

    }

    @Test
    public void testGetTheatres() {
        List<Theatre> theatreList = new ArrayList<>();
        theatreList.add(new Theatre());
        theatreList.add(new Theatre());

        when(theatreRepository.findAll()).thenReturn(theatreList);

        List<Theatre> theatres = theatreService.getTheatres();

        assertNotNull(theatres);

    }

    @Test
    public void testTheatresByCity() {
        List<Theatre> theatreList = new ArrayList<>();
        theatreList.add(new Theatre());
        theatreList.add(new Theatre());

        when(theatreRepository.getTheatresByCity(anyString())).thenReturn(theatreList);
        List<Theatre> theatres = theatreService.getTheatresByCity("c01");

        assertNotNull(theatres);

    }

    @Test
    public void testTheatresByCityInvalid() {
        List<Theatre> theatreList = new ArrayList<>();

        when(theatreRepository.getTheatresByCity(anyString())).thenReturn(theatreList);
        List<Theatre> theatres = theatreService.getTheatresByCity("c01");

        assertTrue(theatres.size() == 0);

    }

    @Test
    public void testGetTheatreNameOnly() {
        String theatreName = "INOX";
        when(theatreRepository.getTheatreNameOnly(anyString())).thenReturn(theatreName);

        String theatreN = theatreService.getTheareNameOnly("t01");

        assertSame(theatreName, theatreN);
    }

    @Test
    public void testGetTheatreNameOnlyInvalid() {
        String theatreName = null;
        when(theatreRepository.getTheatreNameOnly(anyString())).thenReturn(theatreName);

        String theatreN = theatreService.getTheareNameOnly("t01");

        assertNull(theatreN);
    }

}
