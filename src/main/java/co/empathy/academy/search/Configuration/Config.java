package co.empathy.academy.search.Configuration;

import co.empathy.academy.search.Service.SearchEngine;
import co.empathy.academy.search.Service.SearchEngineImpl;
import co.empathy.academy.search.Service.SearchService;
import co.empathy.academy.search.Service.SearchServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// This is the configuration class where we'll define our beans (objects whose lifecycle is managed by Spring)
@Configuration
public class Config {

    @Bean
    public SearchEngine searchEngine() {
        return new SearchEngineImpl();
    }

    @Bean
    public SearchService searchService(SearchEngine searchEngine) {
        return new SearchServiceImpl(searchEngine);
    }




}
