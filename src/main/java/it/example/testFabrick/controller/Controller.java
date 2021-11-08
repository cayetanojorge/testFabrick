package it.example.testFabrick.controller;


import com.google.gson.*;
import it.example.testFabrick.model.balance.Balance;
import it.example.testFabrick.model.bodyerrormoneytransfer.BodyErrorMoneyTransfer;
import it.example.testFabrick.model.details.Details;
import it.example.testFabrick.model.bodyinmoneytransfer.BodyInMoneyTransfer;
import it.example.testFabrick.model.transactions.Transactions;
import it.example.testFabrick.servizi.ApiFabrick;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@RestController
public class Controller {

    private ApiFabrick fabrickApi= new ApiFabrick();


    @GetMapping("/prova")
    public String hello(){
        return "ciao mondo";
    }

    /*
    Retrieves the details of a specific cash account.
     */
    @GetMapping("/detailsAccount")
    public String detailsAccount() throws URISyntaxException {
        JsonObject retJson= fabrickApi.detailsAccountFabrick();
        Details details= new Gson().fromJson(retJson.toString(), Details.class);
        return viewJson(details.toString());
    }

    /**
     *
     * @param inJson
     * @return outJson
     * @throws URISyntaxException
     */
    private String viewJson(String inJson){
        Gson gson= new GsonBuilder().setPrettyPrinting().create();
        JsonElement je= JsonParser.parseString(inJson.toString());
        String outJson= gson.toJson(je);
        return outJson;
    }

    /*
    Retrieves the balance of a specific cash account.
     */
    @GetMapping("/balanceAccount")
    public String balanceAccount() throws URISyntaxException {
        JsonObject retJson= fabrickApi.balanceAccountFabrick();
        Balance balance= new Gson().fromJson(retJson.toString(), Balance.class);
        return viewJson(balance.toString());
    }

    /*
    Retrieves the transactions of a specific cash account.
     */
    @GetMapping("/transactionsAccount")
    public String transactionsAccount() throws URISyntaxException {
        JsonObject retJson= fabrickApi.transactionsAccountFabrick();
        Transactions transactions= new Gson().fromJson(retJson.toString(), Transactions.class);
        return viewJson(transactions.toString());
    }

    /*
    Creates a new money transfer
     */
    @PostMapping("/transferMoney")
    public String transferMoney() throws URISyntaxException {
        JsonObject retJson= fabrickApi.moneyTransferAccountFabrick();
        BodyErrorMoneyTransfer bodyError= new Gson().fromJson(retJson.toString(), BodyErrorMoneyTransfer.class);
        return viewJson(bodyError.toString());
    }

    /*
    Creates a new money transfer
     */
    @PostMapping("/transferMoney2")   //TODO vedere file 'todo.txt' in 'resources'
    public String transferMoney2(@RequestBody String bodyIn) throws URISyntaxException {
        //System.out.println("ricevuto body json: \n" + bodyIn.toString());
        JsonObject retJson= fabrickApi.moneyTransferAccountFabrick(bodyIn);
        BodyErrorMoneyTransfer bodyError= new Gson().fromJson(retJson.toString(), BodyErrorMoneyTransfer.class);
        return viewJson(bodyError.toString());
    }
}
