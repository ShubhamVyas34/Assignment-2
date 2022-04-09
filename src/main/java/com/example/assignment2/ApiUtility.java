package com.example.assignment2;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ApiUtility{
    public static ApiResponse getCricketDataFromJSONFile(String fileName){
        //create the gson object
        Gson gson =new Gson();
        ApiResponse response=null;

        //Try with resources
        try(
                FileReader fileReader=new FileReader(fileName);
                JsonReader jsonReader=new JsonReader(fileReader);

                ) {
            //converting the json object to api response
            response=gson.fromJson(jsonReader,ApiResponse.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
    public static ApiResponse getCricketDataFromAPI(String searchTerm){
        searchTerm=searchTerm.replace(" ","20%");
        String uri="https://api.cricapi.com/v1/players?apikey=97209de1-8855-4efe-b6b0-a9a30066286c&offset=0&search="+searchTerm;
        HttpClient client=HttpClient.newHttpClient();
        HttpRequest httpRequest= HttpRequest.newBuilder().uri(URI.create(uri)).build();

        //imp code cause this will creatre 
        try {
            HttpResponse<Path> response=client.send(httpRequest,HttpResponse
                                                .BodyHandlers
                                                .ofFile(Paths.get("JavaApiFetched.json")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getCricketDataFromJSONFile("javaApiFetched.json");
    }
    /*
    * This method will call the api and return the java objects without creating a json file on your hard drive
    * */
    public static ApiResponse getCricketDataFromAPIQuick(String searchTerm){
        searchTerm=searchTerm.replace(" ","20%");
        String uri="https://api.cricapi.com/v1/players?apikey=97209de1-8855-4efe-b6b0-a9a30066286c&offset=0&search="+searchTerm;
        HttpClient client=HttpClient.newHttpClient();
        HttpRequest httpRequest= HttpRequest.newBuilder().uri(URI.create(uri)).build();

        //imp code cause this will creatre
        try {
            HttpResponse<String> response=client.send(httpRequest,HttpResponse
                    .BodyHandlers
                    .ofString());
            Gson gson=new Gson();
            return gson.fromJson(response.body(),ApiResponse.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //this method fetches the country name and returns it to team details objects
    public static TeamDetails getTeamDetails(String id){
        String uri="https://api.cricapi.com/v1/players_info?apikey=97209de1-8855-4efe-b6b0-a9a30066286c&offset=0&id="+id;
        HttpClient client=HttpClient.newHttpClient();
        HttpRequest httpRequest= HttpRequest.newBuilder().uri(URI.create(uri)).build();

        //imp code cause this will creatre
        try {
            HttpResponse<String> response=client.send(httpRequest,HttpResponse
                    .BodyHandlers
                    .ofString());
            Gson gson=new Gson();
            return gson.fromJson(response.body(),TeamDetails.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

}
