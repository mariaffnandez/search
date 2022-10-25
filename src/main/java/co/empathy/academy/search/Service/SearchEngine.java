package co.empathy.academy.search.Service;

import java.io.IOException;

public interface SearchEngine {

    String search(String query) throws IOException, InterruptedException;
}
