package com.spgtesting.Ex03_Get_Request;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class APITesting008_Get_NonBDDStyle {

    RequestSpecification r;
    Response rs;
    ValidatableResponse vr;

    @Description("Verify the Get request with Positive value")
    @Test
    public void test1_NonBDD_GET(){
        String Pincode="560048";
        r= RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("IN/"+Pincode);

        rs=r.when().log().all().get();
        vr=rs.then().log().all().statusCode(200);
    }

    @Description("Verify the Get request with negative value")
    @Test
    public void test2_NonBDD_GET(){
        String Pincode="-1";
        r= RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("IN/"+Pincode);

        rs=r.when().log().all().get();
        vr=rs.then().log().all().statusCode(404);
    }
}
