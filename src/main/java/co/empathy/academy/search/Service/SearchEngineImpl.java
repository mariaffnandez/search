package co.empathy.academy.search.Service;


import co.elastic.clients.elasticsearch.ElasticsearchClient;

import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import co.empathy.academy.search.Model.JSONResponse;
import org.apache.http.HttpHost;

import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.*;

import org.json.JSONObject;

import java.io.IOException;



public class SearchEngineImpl implements SearchEngine {

    // This method should make a request to Elasticsearch to retrieve search results


    @Override
    public String search(String query) throws IOException, InterruptedException {
        if (query == null) {
            throw new RuntimeException("Query is mandatory");
        } else {
            //creating the elasticsearchClient ¿better in config?

            RestClient httpClient
                    = RestClient.builder(new HttpHost("localhost",9200))
                    .build();

            ElasticsearchTransport transport= new RestClientTransport(httpClient,new JacksonJsonpMapper());
            ElasticsearchClient elasticClient= new ElasticsearchClient(transport);

            //Calling the api to get ingo
            Request request = new Request(
                    "GET",
                    "/");

            String responseElastic= EntityUtils.toString(httpClient.performRequest(request).getEntity());

            //getting the clustername
            JSONObject jsonObject= new JSONObject(responseElastic);
            String clusterName=jsonObject.get("cluster_name").toString();

            return new JSONResponse().getResponseQueryClusterName(query,clusterName);

        }


    }

}