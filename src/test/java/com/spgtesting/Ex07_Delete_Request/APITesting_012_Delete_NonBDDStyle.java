package com.spgtesting.Ex07_Delete_Request;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.qameta.allure.Description;
import org.testng.annotations.Test;



public class APITesting_012_Delete_NonBDDStyle {

    @Description("Verify the delete Request API")
    @Test
    public void test_delete_nonBDD() {


        String token = "85f81492f31f072";
        String bookingId = "2107";

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/" + bookingId);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("Token",token);
        //requestSpecification.header("Authorization", "Bearer " + token);
       // requestSpecification.auth().basic("admin","password123");

        Response response = requestSpecification.when().delete();

        ValidatableResponse validatableResponse = response.then().log().all();
        validatableResponse.statusCode(201);
    }
}