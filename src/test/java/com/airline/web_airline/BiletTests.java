package com.airline.web_airline;

import com.airline.web_airline.model.Bilet;
import com.airline.web_airline.repository.BiletRepositoryContract;
import com.airline.web_airline.service.BiletService;
import com.airline.web_airline.service.BiletServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.Mockito.verify;

public class BiletTests {

    @Mock
    private BiletRepositoryContract biletRepositoryMock;

    private BiletService biletService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        biletService = new BiletServiceImpl(biletRepositoryMock);
    }

    @Test
    public void saveBiletTest() {
        Bilet expectedBilet = new Bilet(1, "Bucuresti", "Timisoara", LocalDate.of(2024, 4, 15), 0, 80, "15:30", "600 RON" );
        biletService.saveBilet(expectedBilet);
        verify(biletRepositoryMock).saveTicket(expectedBilet);
    }

    @Test
    public void getAllBileteTest(){
        biletService.getAllBilete();
        verify(biletRepositoryMock).getAllAvailableTickets();
    }

    @Test
    public void getBiletByIdTest(){
        int id = 2;
        biletService.getBiletById(id);
        verify(biletRepositoryMock).getTicketById(id);
    }

    @Test
    public void deleteBiletByIdTest(){
        int id = 2;
        biletService.deleteBiletById(id);
        verify(biletRepositoryMock).deleteTicketById(id);
    }

    @Test
    public void findByOrasPlecareTest(){
        String orasPlecare = "Cluj-Napoca";
        biletService.findByOrasPlecare(orasPlecare);
        verify(biletRepositoryMock).findBiletsByOrasPlecare(orasPlecare);
    }

    @Test
    public void findByQueryTest(){
        String orasPlecare = "Madrid";
        Optional<String> orasDestinatie = Optional.of("Bucuresti");
        Optional<LocalDate> dataPlecare = Optional.of(LocalDate.of(2024, 4, 28));
        biletService.findByQuery(orasPlecare, orasDestinatie, dataPlecare);
        verify(biletRepositoryMock).findBiletsByOrasPlecareAndOrasDestinatieAndDataPlecareIsAfter(orasPlecare, orasDestinatie, dataPlecare);
    }

}
