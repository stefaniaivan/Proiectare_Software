package com.airline.web_airline;

import com.airline.web_airline.model.Comanda;
import com.airline.web_airline.model.User;
import com.airline.web_airline.repository.ComandaRepository;
import com.airline.web_airline.service.ComandaService;
import com.airline.web_airline.service.ComandaServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.mockito.Mockito.verify;

public class ComandaTests {
    @Mock
    private ComandaRepository comandaRepositoryMock;

    private ComandaService comandaService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        comandaService = new ComandaServiceImpl(comandaRepositoryMock);
    }

    @Test
    public void saveUserTest() {
        Comanda expectedOrder = new Comanda(2, 3, 5, LocalDate.of(2024, 4, 15), "500 RON", "platit" );
        comandaService.saveComanda(expectedOrder);
        verify(comandaRepositoryMock).save(expectedOrder);
    }

    @Test
    public void getOrderByIdTest(){
        int id = 2;
        comandaService.getOrderById(id);
        verify(comandaRepositoryMock).findById(id);
    }

    @Test
    public void deleteOrderByIdTest(){
        int id = 2;
        comandaService.deleteOrderById(id);
        verify(comandaRepositoryMock).deleteById(id);
    }

}
