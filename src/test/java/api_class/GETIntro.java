package api_class;

import org.apache.hc.core5.net.URIBuilder;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class GETIntro {

    /**
     * Building API Request
     * Launch/Initialize the client
     * Construct URL
     * Define the Http method(Get, Post, Put, Delete)
     * Add parameters(if needed)
     * -pat params
     * -query params
     * headers params
     * 4-Click on Send button/execute a call.
     */

    @Test
    public void getTest() throws URISyntaxException, IOException {

        //initialize the client
        HttpClient client = HttpClientBuilder.create().build();

        //construct URL:  https://petstore.swagger.io/v2/store/inventory
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("petstore.swagger.io");
        uriBuilder.setPath("v2/store/inventory");

        //Define the Http Method
        HttpGet httpGet = new HttpGet(uriBuilder.build());


        //Add parameters
        httpGet.addHeader("accept", "application/json");


        //execute API call

        HttpResponse response = client.execute(httpGet);

        Assert.assertEquals(200, response.getStatusLine().getStatusCode());


    }


    @Test
    public void getTestB() throws URISyntaxException, IOException {

        //initialize the client
        HttpClient client = HttpClientBuilder.create().build();

        //construct URL:  https://reqres.in/api/users/2
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("reqres.in");
        uriBuilder.setPath("api/users/2");

        //Define the Http Method
        HttpGet httpGet = new HttpGet(uriBuilder.build());

        //Add parameters
        httpGet.addHeader("accept", "application/json");


        //execute API call

        HttpResponse response = client.execute(httpGet);

        Assert.assertEquals(200, response.getStatusLine().getStatusCode());


    }


    @Test
    public void getTestC() throws URISyntaxException, IOException {

        //initialize the client
        HttpClient client = HttpClientBuilder.create().build();

        //construct URL:  https://reqres.in/api/users/123
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("reqres.in");
        uriBuilder.setPath("api/users/123");

        //Define the Http Method
        HttpGet httpGet = new HttpGet(uriBuilder.build());


        //Add parameters
        httpGet.addHeader("accept", "application/json");


        //execute API call

        HttpResponse response = client.execute(httpGet);

        Assert.assertEquals(404, response.getStatusLine().getStatusCode());


    }

}


