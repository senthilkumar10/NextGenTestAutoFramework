package com.tac.utility;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


/**
 * @author senthil
 */
public final class ELKUtils {

    private ELKUtils(){}

    public static void sendDataToELK(String testName, String status){
        Map<String,String> map = new HashMap<>();
        map.put("testName",testName);
        map.put("status",status);
        map.put("executionTime", LocalDateTime.now().toString());

        Response response = RestAssured.given()
                .header("Content-Type","application/json")
                .log()
                .all()
                .body(map)
                .post("http://localhost:9200/regression/results");

        Assert.assertEquals(response.statusCode(),201);

        response.prettyPrint();
    }


}
