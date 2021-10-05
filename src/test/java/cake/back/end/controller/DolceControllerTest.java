package cake.back.end.controller;

import cake.back.end.dao.DolceRepository;
import cake.back.end.entity.Dolce;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.*;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DolceController.class)
class DolceControllerTest {

    @Autowired
    WebApplicationContext webApplicationContext;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    DolceRepository dolceRepository;

    Dolce RECORD_1 = new Dolce(1l, "Tiramisù", new BigDecimal(8.50) , "Il tiramisù è sicuramente uno dei dessert più golosi e conosciuti al mondo.", "assets/images/dolci/tiramisu.jpeg", false, 10, 544, new Date(), null, null);
    Dolce RECORD_2 = new Dolce(2l, "Brownies", new BigDecimal(4.50) , "Dolcetti tipicamente americani realizzati con cioccolato fondente e nocciole.", "assets/images/dolci/brownies.jpeg", false, 100, 902, new Date(), null, null);
    Dolce RECORD_3 = new Dolce(3l, "Pancake", new BigDecimal(9.00) , "Soffici frittelle da guarnire come si preferisce.", "assets/images/dolci/pancake.jpeg", false, 60, 263, new Date(), null, null);

    @BeforeEach
    void setUp() {}

    @Test
    public void testFindAll() throws Exception {
        List<Dolce> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));

        when(dolceRepository.findAll()).thenReturn(records);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/dolci")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$", hasSize(3)))
                .andExpect((ResultMatcher) jsonPath("$[1].nome", is("Brownies")));
    }

    @Test
    void testFindById() {
        // Setup our mock repository
        doReturn(Optional.of(RECORD_1)).when(dolceRepository).findById(1l);

        // Execute the service call
        Optional<Dolce> returnedWidget = dolceRepository.findById(1l);

        // Assert the response
        Assertions.assertTrue(returnedWidget.isPresent(), "Dolce non trovato");
        Assertions.assertSame(returnedWidget.get(), RECORD_1, "Il dolce restituito non è uguale a quello del mock");
    }

}