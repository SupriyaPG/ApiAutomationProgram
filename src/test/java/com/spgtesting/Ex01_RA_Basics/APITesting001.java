package com.spgtesting.Ex01_RA_Basics;

import io.restassured.RestAssured;

import java.util.Scanner;

public class APITesting001 {
    public static void main(String[] args) {

        // Gherkins Syntax
// Given() -> Pre Req. - URL, Headers, Auth, Body....
// When() -> HTTP method? - GET/POST/PUT/PATCH, DELETE...
// Then() -> Validation -> 200 oK, firstname == PRAMOD

        //Full URL - https://api.zippopotam.us/IN/411038
        //Base URI - https://api.zippopotam.us
        //Base Path - IN/411038



        RestAssured
                .given()
                    .baseUri("https://api.zippopotam.us").basePath( "IN/411038")
                .when()
                 .get()
                .then().log().all().statusCode(200);

    }
}
