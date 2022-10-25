package co.empathy.academy.search.Service;

import java.io.IOException;

public class SearchServiceImpl implements SearchService {

    private final SearchEngine searchEngine;

    public SearchServiceImpl(SearchEngine searchEngine) {
        this.searchEngine = searchEngine;
    } //SearchService depends on SearchEngine

    @Override
    public String search(String query) throws IOException, InterruptedException {


        return searchEngine.search(query);
    }
}