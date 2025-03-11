package com.spgtesting.Ex06_Patch_Request;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting011_Patch_NonBDDStyle {

    RequestSpecification rs;
    Response r;
    ValidatableResponse vr;

    @Description("Verify the put request for the Restful Booker APIS")
    @Test
    public void test_put_non_bdd()
    {
        String token="e9d30ab92374876";
        String bookingId="2107";
        String payloadPatch="{\n" +
                "    \"firstname\" : \"Jame\",\n" +
                "    \"lastname\" : \"Brown\"\n" +
                "}";

        rs= RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking/"+bookingId);
        rs.contentType(ContentType.JSON);
        rs.body(payloadPatch).log().all();

        rs.cookie("Token",token);
        //rs.header("Authorization", "Bearer " + token);
        //rs.auth().basic("admin","password123");


        r=rs.when().log().all().patch();

        vr=r.then().log().all();
        vr.statusCode(200);
    }
}
