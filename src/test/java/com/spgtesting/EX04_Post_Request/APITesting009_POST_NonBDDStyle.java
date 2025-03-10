package com.spgtesting.EX04_Post_Request;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting009_POST_NonBDDStyle {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Description
    @Test
    public void test_POST_NonBDDStyle_Create_Token(){
        String payload="{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        r= RestAssured.given(); //Part 1 Preparing Request URL,Header,Auth
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.contentType(ContentType.JSON);
        r.body(payload).log().all();

        response=r.when().log().all().post(); //Part 2 Making HTTP Request

        vr=response.then(). log().all(); //part3 Verification
        vr.statusCode(200);

    }
}
