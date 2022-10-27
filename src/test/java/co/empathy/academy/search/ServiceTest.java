package co.empathy.academy.search;

import co.empathy.academy.search.Model.Response;
import co.empathy.academy.search.Service.SearchEngine;
import co.empathy.academy.search.Service.SearchService;
import co.empathy.academy.search.Service.SearchServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {

    
    @Test

    void givenQueryWithResults_whenSearch_thenReturnResponse() throws IOException, InterruptedException {
        String query = "query";
        String expectedResponse= new Response().getResponseQueryClusterName(query, "docker");
        SearchEngine searchEngine = mock(SearchEngine.class);
        given(searchEngine.search(query)).willReturn(expectedResponse);

        SearchService searchService = new SearchServiceImpl(searchEngine);

        String realResponse = searchService.search(query);
        assertThat(expectedResponse).isEqualTo(realResponse);
    }

    @Test
    void givenNoQuery_whenSearch_thenReturnException() throws IOException, InterruptedException {
        SearchEngine searchEngine = mock(SearchEngine.class);
        Throwable expectedException = new RuntimeException("Error while searching");
        given(searchEngine.search(null)).willThrow(expectedException);

        SearchService searchService = new SearchServiceImpl(searchEngine);

        assertThrows(expectedException.getClass(), () -> searchService.search(null));
    }

}
