package co.empathy.academy.search;

import co.empathy.academy.search.Service.SearchEngine;
import co.empathy.academy.search.Service.SearchService;
import co.empathy.academy.search.Service.SearchServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class SearchApplicationTests {
	@Autowired
	private MockMvc mvc;

	//NOT FINISHED
	@Test
	//example
	void givenQueryWithResults_whenSearch_thenReturnNonZeroNumFound() throws IOException, InterruptedException {
		String query = "query with results";
		SearchEngine searchEngine = mock(SearchEngine.class);
		given(searchEngine.search(query)).willReturn("query");

		SearchService searchService = new SearchServiceImpl(searchEngine);

		//int numResults = searchService.search(query);

		//assertTrue(numResults > 0);
	}


}
