package com.spgtesting.Ex10_PayloadManagement;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;


import java.util.LinkedHashMap;
import java.util.Map;

public class APITesting_26_RestAssured_Payload_Map {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    String token;
    Integer bookingId;

    @Test
    public void test_POST()
    {

//        String payload_Post="{\n"+
//                "\"firstname\": \"Josh\",\n"+
//                "\"lastname\": \"Allen\",\n"+
//                "\"totalprice\": 111,\n"+
//                "\"depositpaid\": true,\n"+
//                "\"bookingdates\": {\n"+
//                "\"checkin\":\"2018-01-01\",\n"+
//                "\"checkout\":\"2019-01-01\"\n"+
//                "},\n"+
//                "\"additionalneeds\": \"super bowls\"\n"+
//                "}";

        //If we have to write 100 test cases then string payload is suggested.
        //instead of string payload we can use hashmap as bellow
        //when 100 to 500 testcases have to write then use hashmap
//
        Map<String,Object>jsonBodyUsingMap=new LinkedHashMap<>();
        jsonBodyUsingMap.put("firstname","Josh");
        jsonBodyUsingMap.put("lastname","Allen");
        jsonBodyUsingMap.put("totalprice",111);
        jsonBodyUsingMap.put("depositpaid",false);

        Map<String,Object>bookingDatesMap=new LinkedHashMap<>();
        bookingDatesMap.put("checkin","2018-01-01");
        bookingDatesMap.put("checkout","2019-01-01");

        jsonBodyUsingMap.put("bookingdates",bookingDatesMap);
        jsonBodyUsingMap.put("additionalneeds","super bowls");
        System.out.println(jsonBodyUsingMap);

        //but very rarely use this

        //Response payload -->
        // {firstname=Josh, lastname=Allen, totalprice=111, depositpaid=false, bookingdates={checkin=2018-01-01, checkout=2019-01-01}, additionalneeds=super bowls}

        //GSOn and jacson API convert the Map to JSON files

    }

}
