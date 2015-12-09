package SDK;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

//ServerConnection consists of the HTTP methods get, post, put and delete
public class ServerConnection {

    //Declaration
    private String hostAddress;
    private int port;
    WebResource webResource;
    ClientResponse response;

    Client client = Client.create();

    //Constructor with initialization
    public ServerConnection() {
        this.hostAddress = "http://localhost";
        this.port = 9998;
    }

    public void setHostAddress(String hostAddress) {
        this.hostAddress = hostAddress;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHostAddress() {
        return hostAddress;
    }

    public int getPort() {
        return port;
    }

    //Get is a HTTP read-only method used to request data
    public String get(String path) {
        webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        response = webResource.type("application/json").get(ClientResponse.class);

        return response.getEntity(String.class);
    }

    //post is a HTTP write-method used to submit data
    public String post(String json, String path) {

        webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        response = webResource.type("application/json").post(ClientResponse.class, json);

        return response.getEntity(String.class);
    }

    // delete is a HTTP write-method used to delete data
    public String delete(String path) {
        webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        response = webResource.type("application/json").delete(ClientResponse.class);

        return response.getEntity(String.class);
    }

    //update is a HTTP method used to update data
    public String put(String json, String path) {
        String message = null;
        webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        response = webResource.type("application/json").put(ClientResponse.class, json);

        if (response != null) {
            message = response.getEntity(String.class);
        }

        return message;
    }
}