package com.spgtesting.Ex01_RA_Basics;

import io.restassured.RestAssured;

import java.util.Scanner;

public class APITesting002 {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your pincode:");
        String pinCode = sc.nextLine();

        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("IN/"+pinCode)
                .get().
                then().log().all().statusCode(200);
    }
}
