package co.empathy.academy.search;

import co.empathy.academy.search.Model.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc

class ControllersTest {
    @Autowired
    private MockMvc mvc;

    @Test
    void greet() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/greet/{name}", "Maria"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello Maria"));
    }

    @Test
    void searchQuery() throws Exception{
        String query= "query";
        String queryResponse= new Response(query,"docker-cluster").getResponse();
        mvc.perform(MockMvcRequestBuilders.get("/search?query=query"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(queryResponse));
    }

}