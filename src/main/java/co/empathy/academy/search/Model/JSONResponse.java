package co.empathy.academy.search.Model;



import java.util.HashMap;
import java.util.Map;


public class JSONResponse {

    public String getResponseQueryClusterName(String query, String clusterName)
    {
        Map<String, Object> map = new HashMap<>();
        map.put("query", query);
        map.put("clusterName", clusterName);
        return map.toString();


    }

}
