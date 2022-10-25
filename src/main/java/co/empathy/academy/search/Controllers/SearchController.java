package co.empathy.academy.search.Controllers;

import co.empathy.academy.search.Service.SearchEngineImpl;
import co.empathy.academy.search.Service.SearchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController

public class SearchController {

    //@Autowired
    private SearchServiceImpl service;

    @GetMapping("/search")
    public String searchLogDataByTerm(@RequestParam("query") String query) throws IOException, InterruptedException {
        service= new SearchServiceImpl(new SearchEngineImpl());
        return service.search(query);
    }

}
