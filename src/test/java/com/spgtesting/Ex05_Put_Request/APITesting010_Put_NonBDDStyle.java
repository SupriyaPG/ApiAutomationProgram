package com.spgtesting.Ex05_Put_Request;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting010_Put_NonBDDStyle {

    @Description("Verify the put rwquest for the Restful Booker APIS")
    @Test
    public void test_put_non_bdd()
    {
        String token="85f81492f31f072";
        String bookingId="2035";
        String payloadPut="{\n" +
                "    \"firstname\": \"MR.55\",\n" +
                "    \"lastname\": \"Khan241\",\n" +
                "    \"totalprice\": 76551,\n" +
                "    \"depositpaid\": true,\n" +
                "    \"bookingdates\": {\n" +
                "        \"checkin\": \"2024-01-01\",\n" +
                "        \"checkout\": \"2024-01-02\"\n" +
                "    }\n" +
                "}";

        RequestSpecification requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/"+bookingId);
        requestSpecification.contentType(ContentType.JSON);
       // requestSpecification.cookie("Token",token);
        requestSpecification.header("Authorization", "Bearer " + token);
        requestSpecification.body(payloadPut).log().all();

        Response response=requestSpecification.when().put();

        ValidatableResponse validatableResponse=response.then().log().all();
        validatableResponse.statusCode(200);
    }

}
