package it.example.testFabrick.controller;


import com.google.gson.Gson;
import it.example.testFabrick.model.User;
import it.example.testFabrick.servizi.ApiFabrick;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.websocket.server.PathParam;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {

    //ApiFabrick fabrickApi= new ApiFabrick();

    RestTemplate restTemplate= new RestTemplate();
    static final String defaultUrl= "https://sandbox.platfr.io";
    static final Long accountId= 14537780l;


    @GetMapping("/prova")
    public String hello(){
        return "ciao mondo";
    }

    /*
    Retrieves the details of a specific cash account.
     */
    @GetMapping("/detailsAccount")
    public String detailsAcc() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(defaultUrl + "/api/gbs/banking/v4.0/accounts/" + accountId))
                .GET()
                .header("Content-Type", "application/json")
                .header("Auth-Schema", "S2S")
                .header("Api-Key", "FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP")
                .build();
        // Send HTTP request
        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        return response.body();
    }


    /*
    Retrieves the balance of a specific cash account.
     */
    @GetMapping("/balanceAccount")
    public String balanceAcc() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(defaultUrl + "/api/gbs/banking/v4.0/accounts/" + accountId + "/balance"))
                .GET()
                .header("Content-Type", "application/json")
                .header("Auth-Schema", "S2S")
                .header("Api-Key", "FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP")
                .build();
        // Send HTTP request
        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());
        return response.body();
    }


    /*
    Creates a new money transfer
     */
    @PostMapping("/transferMoney") //TODO
    public String transferMoney() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(defaultUrl + "/api/gbs/banking/v4.0/accounts?accountId=" + accountId + "/payments/money-transfers"))
                .GET()   //<--
                .header("Content-Type", "application/json")
                .header("Auth-Schema", "S2S")
                .header("Api-Key", "FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP")
                .build();
        // Send HTTP request
        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    /*
    Retrieves the transactions of a specific cash account.
     */
    @GetMapping("/transactionsAccount")
    public String transactionAcc() throws IOException, InterruptedException {
        String fromDate= "2021-09-01";
        String toDate= "2021-10-01";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(defaultUrl + "/api/gbs/banking/v4.0/accounts/" + accountId +
                        "/transactions?fromAccountingDate=" + fromDate + "&toAccountingDate=" + toDate))
                .GET()
                .header("Auth-Schema", "S2S")
                .header("Api-Key", "FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP")
                .header("Content-Type", "application/json")
                .build();
        // Send HTTP request
        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

}
