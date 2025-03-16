package com.spgtesting.Ex09_Assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class APITesting_23_RestAssured_Assertion {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;


    @Test
    public void test_Post(){

        String payload_Post="{\n"+
                "\"firstname\": \"Josh\",\n"+
                "\"lastname\": \"Allen\",\n"+
                "\"totalprice\": 111,\n"+
                "\"depositpaid\": true,\n"+
                "\"bookingdates\": {\n"+
                "\"checkin\":\"2018-01-01\",\n"+
                "\"checkout\":\"2019-01-01\"\n"+
                "},\n"+
                "\"additionalneeds\": \"super bowls\"\n"+
                "}";

        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload_Post).log().all();

        Response response=requestSpecification.when().post();

        //get validatable response to perform validation
        validatableResponse=response.then().log().all();

        //Rest Assured
        validatableResponse.statusCode(200);

        //Rest Assured-> import org.hamcrest.Matchers;

        //firstname ==Josh, lastname=Allen
        //bookingId shouldn't null

        validatableResponse.body("booking.firstname",Matchers.equalTo("Josh"));
        validatableResponse.body("booking.lastname",Matchers.equalTo("Allen"));
        validatableResponse.body("booking.depositpaid",Matchers.equalTo(true));
        validatableResponse.body("bookingid",Matchers.notNullValue());

    }
}
