package it.example.testFabrick.servizi;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import it.example.testFabrick.model.bodyinmoneytransfer.BodyInMoneyTransfer;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

public class ApiFabrick {


    private RestTemplate restTemplate;
    private HttpHeaders headers;

    static final private Long accountId= 14537780l;
    static final private String defaultUrl= "https://sandbox.platfr.io";

    static final private String details= "/api/gbs/banking/v4.0/accounts/" + accountId;
    static final private String balance= "/api/gbs/banking/v4.0/accounts/" + accountId + "/balance";
    static final private String fromDate= "2021-09-01";
    static final private String toDate= "2021-10-01";
    static final private String transactions= "/api/gbs/banking/v4.0/accounts/" + accountId +
            "/transactions?fromAccountingDate=" + fromDate + "&toAccountingDate=" + toDate;
    static final private String moneyTransfer= "/api/gbs/banking/v4.0/accounts/" + accountId + "/payments/money-transfers";

    static final private String postJsonMoneyTransfer="{\n" +
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



    public ApiFabrick(){
        this.restTemplate= new RestTemplate();
        this.headers= new HttpHeaders();
        setHeaders();
    }

    private void setHeaders() {
        this.headers.setContentType(MediaType.APPLICATION_JSON);
        this.headers.set("Auth-Schema", "S2S");
        this.headers.set("Api-Key", "FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP");
    }


    /**
     *
     * @return JsonObject = Retrieves the details of a specific cash account.
     * @throws URISyntaxException
     */
    public JsonObject detailsAccountFabrick() throws URISyntaxException {
        URI url= new URI(defaultUrl + details);
        System.out.print("[FABRICK] Call to API 'detailsAccount'" + url.toString());

        HttpEntity<String> request= new HttpEntity<>("parameters", headers);
        ResponseEntity<String> response= restTemplate.exchange(url, HttpMethod.GET, request, String.class);

        if(response.getStatusCode()==HttpStatus.OK){
            System.out.println(" ==> OK chiamata API");
            return jsonReturnPayload(response.getBody());
        }
        System.out.println(" -- ERROR chiamata API");
        return null;
    }


    /**
     *
     * @return JsonObject = Retrieves the balance of a specific cash account.
     * @throws URISyntaxException
     */
    public JsonObject balanceAccountFabrick() throws URISyntaxException {
        URI url= new URI(defaultUrl + balance);
        System.out.print("[FABRICK] Call to API 'balanceAccount'" + url.toString());

        HttpEntity<String> request= new HttpEntity<>("parameters", headers);
        ResponseEntity<String> response= restTemplate.exchange(url, HttpMethod.GET, request, String.class);

        if(response.getStatusCode()==HttpStatus.OK){
            System.out.println(" ==> OK chiamata API");
            return jsonReturnPayload(response.getBody());
        }
        System.out.println(" -- ERROR chiamata API");
        return null;
    }

    /**
     *
     * @return JsonObject = Retrieves the transactions of a specific cash account.
     * @throws URISyntaxException
     */
    public JsonObject transactionsAccountFabrick() throws URISyntaxException {
        URI url= new URI(defaultUrl + transactions);
        System.out.print("[FABRICK] Call to API 'transactionsAccount'" + url.toString());

        HttpEntity<String> request= new HttpEntity<>("parameters", headers);
        ResponseEntity<String> response= restTemplate.exchange(url, HttpMethod.GET, request, String.class);

        if(response.getStatusCode()==HttpStatus.OK){
            System.out.println(" ==> OK chiamata API");
            return jsonReturnPayload(response.getBody());
        }
        System.out.println(" -- ERROR chiamata API");
        return null;
    }


    /**
     *
     * @return JsonObject = Creates a new money transfer
     * @throws URISyntaxException
     */
    public JsonObject moneyTransferAccountFabrick() throws URISyntaxException {
        URI url= new URI(defaultUrl + moneyTransfer);
        System.out.print("[FABRICK] Call to API 'moneyTransferAccount'" + url.toString());

        HttpEntity<String> request= new HttpEntity<>(postJsonMoneyTransfer, headers);
        ResponseEntity<String> response=null;
        try {
            response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
        }
        catch (HttpClientErrorException e){
            System.out.println(" -- ERROR chiamata API");
            //System.out.println(e.getResponseBodyAsString());
            return stringReturnAsJson(e.getResponseBodyAsString());
        }
        return null;
    }

    public JsonObject moneyTransferAccountFabrick(String bodyIn) throws URISyntaxException {
        URI url= new URI(defaultUrl + moneyTransfer);
        System.out.print("[FABRICK] Call to API 'moneyTransferAccount2'" + url.toString());

        HttpEntity<String> request= new HttpEntity<>(bodyIn, headers);
        ResponseEntity<String> response=null;
        try {
            response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
        }
        catch (HttpClientErrorException e){
            System.out.println(" -- ERROR chiamata API");
            //System.out.println(e.getResponseBodyAsString());
            return stringReturnAsJson(e.getResponseBodyAsString());
        }
        return null;
    }




    private JsonObject jsonReturnPayload(String resp){
        JsonElement jsonElement= new JsonParser().parse(resp);
        JsonObject retJson= jsonElement.getAsJsonObject().getAsJsonObject("payload");
        return retJson;
    }

    private JsonObject stringReturnAsJson(String resp){
        JsonElement jsonElement= new JsonParser().parse(resp);
        JsonObject retJson= jsonElement.getAsJsonObject();
        return retJson;
    }

}
