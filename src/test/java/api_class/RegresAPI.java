package api_class;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.core5.net.URIBuilder;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public class RegresAPI {


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
    public void getUserByIdTest() throws URISyntaxException, IOException {

        //Initialize the client

        HttpClient client = HttpClientBuilder.create().build();
        //Construct URL https://reqres.in/api/users/1
        URIBuilder uriBuilder = new URIBuilder();

        uriBuilder.setScheme("https").setHost("reqres.in").setPath("api/users/1");

        //Define the Http Method
        HttpGet get = new HttpGet(uriBuilder.build());
        //Add parameters
        get.addHeader("accept", "application/json");


        //execute API call
        HttpResponse response = client.execute(get);
        int actualStatusCode = response.getStatusLine().getStatusCode();

        //verify status code
        Assert.assertEquals(HttpStatus.SC_OK, actualStatusCode);
        ; //httpstatus_sc_ok stands for status code (200)

        //verify response header : === contentType
        Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));

        //get this json and Map it (key is always String:data(in response part) and Object can fit with any data type(int,boolean,string)
        //that's why we use Object
        // This is how we map the Json to Java
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> dataFromResponse = objectMapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {
                });

        System.out.println(dataFromResponse.get("data")); // It is going to give all the information under the data keyword in the response part.

        Map<String, Object> data = (Map<String, Object>) dataFromResponse.get("data"); //we can get the element from inside of data
        System.out.println(data.get("first_name"));


    }

    @Test
    public void getUserByIdTestA() throws URISyntaxException, IOException {

        //Initialize the client

        HttpClient client = HttpClientBuilder.create().build();
        //Construct URL https://reqres.in/api/users/1
        URIBuilder uriBuilder = new URIBuilder();

        uriBuilder.setScheme("https").setHost("reqres.in").setPath("api/users/1");

        //Define the Http Method
        HttpGet get = new HttpGet(uriBuilder.build());
        //Add parameters
        get.addHeader("accept", "application/json");


        //execute API call
        HttpResponse response = client.execute(get);

        //verify status code
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
        ; //httpstatus_sc_ok stands for status code (200)

        //verify response header : === contentType
        Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));

        //get this json and Map it (key is always String:data(in response part) and Object can fit with any data type(int,boolean,string)
        //that's why we use Object
        // This is how we map the Json to Java
        //deserialization with ObjectMapper.
        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, Object> deserializedResponse = objectMapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {
                });
        System.out.println(deserializedResponse);
        //  Map<String, String> support = (Map<String, String>) deserializedResponse.get("support");// It is going to give all the information under the "support" keyword in the response part.
        // System.out.println(support.get("url"));
        // System.out.println(support.get("text"));


    }

    /*
    HOMEWORK
    https://reqres.in/api/users/
    and deserialize "data" keyword.

     */

    @Test
    public void getUserByIdTestB() throws URISyntaxException, IOException {

        //Initialize the client

        HttpClient client = HttpClientBuilder.create().build();
        //Construct URL https://reqres.in/api/users/
        URIBuilder uriBuilder = new URIBuilder();

        uriBuilder.setScheme("https").setHost("reqres.in").setPath("api/users/");

        //Define the Http Method
        HttpGet get = new HttpGet(uriBuilder.build());
        //Add parameters
        get.addHeader("accept", "application/json");


        //execute API call
        HttpResponse response = client.execute(get);

        //verify status code
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
        ; //httpstatus_sc_ok stands for status code (200)

        //verify response header : === contentType
        Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));

        //get this json and Map it (key is always String:data(in response part) and Object can fit with any data type(int,boolean,string)
        //that's why we use Object
        // This is how we map the Json to Java
        //deserialization with ObjectMapper.
        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, Object> deserializedResponse = objectMapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {
                });
        System.out.println(deserializedResponse);
        //  Map<String, String> support = (Map<String, String>) deserializedResponse.get("support");// It is going to give all the information under the "support" keyword in the response part.
        // System.out.println(support.get("url"));
        // System.out.println(support.get("text"));

    }

}