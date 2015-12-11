package SDK;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

//API consists of the HTTP methods get, post, put and delete
public class API {

    //Declaration
    private String hostAddress;
    private int port;
    private String api;
    Client client;
    WebResource webResource;
    ClientResponse response;

    //Constructor with initialization
    public API() {
        this.hostAddress = "http://localhost:";
        this.port = 9998;
        this.api = "/api/";
        client = Client.create();
    }

    //Get is a HTTP read-only method used to request data
    public String get(String path) {
        webResource = client.resource(hostAddress + port + api + path);
        response = webResource.type("application/json").get(ClientResponse.class);

        return response.getEntity(String.class);
    }

    //post is a HTTP write-method used to submit data
    public String post(String json, String path) {
        webResource = client.resource(hostAddress + port + api + path);
        response = webResource.type("application/json").post(ClientResponse.class, json);

        return response.getEntity(String.class);
    }

    // delete is a HTTP write-method used to delete data
    public String delete(String path) {
        webResource = client.resource(hostAddress + port + api + path);

        response = webResource.type("application/json").delete(ClientResponse.class);
        return response.getEntity(String.class);
    }

    //put is a HTTP method used to update data
    public String put(String json, String path) {
        webResource = client.resource(hostAddress + port + api + path);
        response = webResource.type("application/json").put(ClientResponse.class, json);

        String message = null;
        if (response != null)
        {
            message = response.getEntity(String.class);
        }
        return message;
    }
}