package co.empathy.academy.search.Model;



import java.util.HashMap;
import java.util.Map;


public class Response {
    private String _query;
    private String _clusterName;

    public Response(String query, String clusterName){
        this._query = query;
        this._clusterName= clusterName;
    }
    public String getResponse()
    {
        Map<String, Object> map = new HashMap<>();
        map.put("query", _query);
        map.put("clusterName", _clusterName);
        return map.toString();

    }

}
