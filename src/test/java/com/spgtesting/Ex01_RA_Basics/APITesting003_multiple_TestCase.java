package com.spgtesting.Ex01_RA_Basics;

import io.restassured.RestAssured;

public class APITesting003_multiple_TestCase {
    public static void main(String[] args) {

        String pinCode;

        pinCode="411006";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("IN/"+pinCode)
                .get().
                then().log().all().statusCode(200);

        pinCode="-1";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("IN/"+pinCode)
                .get().
                then().log().all().statusCode(200);

        pinCode="@";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("IN/"+pinCode)
                .get().
                then().log().all().statusCode(200);
    }
}
