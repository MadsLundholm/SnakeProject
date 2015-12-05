package client.SDK;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

//ServerConnection consists of the HTTP methods get, post, put and delete
public class ServerConnection {

    public ServerConnection(){
        this.hostAddress = "http://localhost";
        this.port = 9998;
    }

    private String hostAddress;
    private int port;

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
    public String get(String path){

        Client client = Client.create();

        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").get(ClientResponse.class);

        String output = response.getEntity(String.class);
        System.out.println(output);

        return output;
    }

    //post is a HTTP write-method used to submit data
    public String post(String json, String path){

        Client client = Client.create();

        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse clientResponse = webResource.type("application/json").post(ClientResponse.class, json);

        String output = clientResponse.getEntity(String.class);

        return output;
    }
    // delete is a HTTP write-method used to delete data
    public String delete (String path){

        Client client = Client.create();

        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse clientResponse = webResource.type("application/json").delete(ClientResponse.class);

        String output = clientResponse.getEntity(String.class);
        System.out.println(output);

        return output;
    }

    public String put(String path, String data) {

        String message = "";
        Client client = Client.create();

        try {
            WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);

            ClientResponse clientResponse = webResource.accept("application/json").put(ClientResponse.class, data);

            if (clientResponse != null) {

                message = clientResponse.getEntity(String.class);

            }

        } catch (ClientHandlerException e) {
            e.printStackTrace();
        }
        return message;
    }
}