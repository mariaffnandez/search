package co.empathy.academy.search.Service;


import org.apache.http.HttpHost;

import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.RestClient;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class SearchEngineImpl implements SearchEngine {

    // This method should make a request to Elasticsearch to retrieve search results

    @Override
    public String search(String query) throws IOException, InterruptedException {
        if (query == null) {
            throw new RuntimeException("Query is mandatory");
        } else {
            //better to do this on config?
            RestClient restClient = RestClient.builder(
                    new HttpHost("localhost", 9200, "http")).build();
            Request request = new Request(
                    "GET",
                    "/");

            String responseElastic= EntityUtils.toString(restClient.performRequest(request).getEntity());
            JSONObject jsonObject= new JSONObject(responseElastic);
            String version=jsonObject.get("version").toString();


            return jsonResponse(query,version);
        }


    }
    private String jsonResponse (String query,String version)
    {
        Map<String, Object> map = new HashMap<>();
        map.put("query", query);
        map.put("clusterName", version);
        return map.toString();

    }
}