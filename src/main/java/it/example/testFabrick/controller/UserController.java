package it.example.testFabrick.controller;


import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

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
    @PostMapping("/transferMoney") //TODO non sicuro corretto
    public String transferMoney() throws IOException {
        /*
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost request = new HttpPost(defaultUrl + "/api/gbs/banking/v4.0/accounts/?accountId=" + accountId + "/payments/money-transfers");
        StringEntity params = new StringEntity("{\n" +
                    "  \"creditor\": {\n" +
                    "    \"name\": \"John Doe\",\n" +
                    "    \"account\": {\n" +
                    "      \"accountCode\": \"IT23A0336844430152923804660\",\n" +
                    "      \"bicCode\": \"SELBIT2BXXX\"\n" +
                    "    },\n" +
                    "    \"address\": {\n" +
                    "      \"address\": null,\n" +
                    "      \"city\": null,\n" +
                    "      \"countryCode\": null\n" +
                    "    }\n" +
                    "  },\n" +
                    "  \"executionDate\": \"2019-04-01\",\n" +
                    "  \"uri\": \"REMITTANCE_INFORMATION\",\n" +
                    "  \"description\": \"Payment invoice 75/2017\",\n" +
                    "  \"amount\": 800,\n" +
                    "  \"currency\": \"EUR\",\n" +
                    "  \"isUrgent\": false,\n" +
                    "  \"isInstant\": false,\n" +
                    "  \"feeType\": \"SHA\",\n" +
                    "  \"feeAccountId\": \"45685475\",\n" +
                    "  \"taxRelief\": {\n" +
                    "    \"taxReliefId\": \"L449\",\n" +
                    "    \"isCondoUpgrade\": false,\n" +
                    "    \"creditorFiscalCode\": \"56258745832\",\n" +
                    "    \"beneficiaryType\": \"NATURAL_PERSON\",\n" +
                    "    \"naturalPersonBeneficiary\": {\n" +
                    "      \"fiscalCode1\": \"MRLFNC81L04A859L\",\n" +
                    "      \"fiscalCode2\": null,\n" +
                    "      \"fiscalCode3\": null,\n" +
                    "      \"fiscalCode4\": null,\n" +
                    "      \"fiscalCode5\": null\n" +
                    "    },\n" +
                    "    \"legalPersonBeneficiary\": {\n" +
                    "      \"fiscalCode\": null,\n" +
                    "      \"legalRepresentativeFiscalCode\": null\n" +
                    "    }\n" +
                    "  }\n" +
                    "}");
        request.addHeader("content-type", "application/json");
        request.addHeader("Auth-Schema", "S2S");
        request.addHeader("Api-Key", "FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP");
        request.setEntity(params);
        CloseableHttpResponse response = httpClient.execute(request);

        //ok
        HttpEntity entity = response.getEntity();
        String entityString = EntityUtils.toString(entity);
        return entityString;*/

        //mi da http error 403 No match found for request
        //ResponseEntityProxy{[Content-Type: application/json,Chunked: true]}
        /*
        final StatusLine statusLine = response.getStatusLine();
        final int status = statusLine.getStatusCode();
        final String statusText = statusLine.getReasonPhrase();
        final String body = response.getEntity().toString();
        StringBuilder strBuf = new StringBuilder();
        strBuf.append("Crowd returned HTTP error code:").append(status);
        strBuf.append(" - ").append(statusText);
        strBuf.append("\n").append(body);
        return strBuf;*/


        //altro modo
        URL url = new URL(defaultUrl + "/api/gbs/banking/v4.0/accounts/?accountId=" + accountId + "/payments/money-transfers");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type","application/json");
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("Auth-Schema", "S2S");
        connection.setRequestProperty("Api-Key", "FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP");
        String payload = "{\n" +
                "  \"creditor\": {\n" +
                "    \"name\": \"John Doe\",\n" +
                "    \"account\": {\n" +
                "      \"accountCode\": \"IT23A0336844430152923804660\",\n" +
                "      \"bicCode\": \"SELBIT2BXXX\"\n" +
                "    },\n" +
                "    \"address\": {\n" +
                "      \"address\": null,\n" +
                "      \"city\": null,\n" +
                "      \"countryCode\": null\n" +
                "    }\n" +
                "  },\n" +
                "  \"executionDate\": \"2019-04-01\",\n" +
                "  \"uri\": \"REMITTANCE_INFORMATION\",\n" +
                "  \"description\": \"Payment invoice 75/2017\",\n" +
                "  \"amount\": 800,\n" +
                "  \"currency\": \"EUR\",\n" +
                "  \"isUrgent\": false,\n" +
                "  \"isInstant\": false,\n" +
                "  \"feeType\": \"SHA\",\n" +
                "  \"feeAccountId\": \"45685475\",\n" +
                "  \"taxRelief\": {\n" +
                "    \"taxReliefId\": \"L449\",\n" +
                "    \"isCondoUpgrade\": false,\n" +
                "    \"creditorFiscalCode\": \"56258745832\",\n" +
                "    \"beneficiaryType\": \"NATURAL_PERSON\",\n" +
                "    \"naturalPersonBeneficiary\": {\n" +
                "      \"fiscalCode1\": \"MRLFNC81L04A859L\",\n" +
                "      \"fiscalCode2\": null,\n" +
                "      \"fiscalCode3\": null,\n" +
                "      \"fiscalCode4\": null,\n" +
                "      \"fiscalCode5\": null\n" +
                "    },\n" +
                "    \"legalPersonBeneficiary\": {\n" +
                "      \"fiscalCode\": null,\n" +
                "      \"legalRepresentativeFiscalCode\": null\n" +
                "    }\n" +
                "  }\n" +
                "}";
        byte[] out = payload.getBytes(StandardCharsets.UTF_8);
        OutputStream stream = connection.getOutputStream();
        stream.write(out);
        String ret= connection.getResponseCode() + " " + connection.getResponseMessage(); // THis is optional
        connection.disconnect();

        return ret;
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
