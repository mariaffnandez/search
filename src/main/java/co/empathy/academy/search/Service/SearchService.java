package co.empathy.academy.search.Service;

import java.io.IOException;

public interface SearchService {
    String search(String query) throws IOException, InterruptedException;

}
