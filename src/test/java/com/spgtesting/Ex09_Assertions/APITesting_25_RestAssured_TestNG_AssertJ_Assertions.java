package com.spgtesting.Ex09_Assertions;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.assertj.core.api.Assertions.*;


public class APITesting_25_RestAssured_TestNG_AssertJ_Assertions {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Integer bookingId;

    @Test
    public void test_Post() {

        String payload_Post = "{\n" +
                "\"firstname\": \"Josh\",\n" +
                "\"lastname\": \"Allen\",\n" +
                "\"totalprice\": 111,\n" +
                "\"depositpaid\": true,\n" +
                "\"bookingdates\": {\n" +
                "\"checkin\":\"2018-01-01\",\n" +
                "\"checkout\":\"2019-01-01\"\n" +
                "},\n" +
                "\"additionalneeds\": \"super bowls\"\n" +
                "}";

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload_Post).log().all();

        Response response = requestSpecification.when().post();

        //get validatable response to perform validation
        validatableResponse = response.then().log().all();

        //Rest Assured
        System.out.println("Rest Assured");
        validatableResponse.statusCode(200);

        validatableResponse.body("booking.firstname", Matchers.equalTo("Josh"));
        validatableResponse.body("booking.lastname", Matchers.equalTo("Allen"));
        validatableResponse.body("booking.depositpaid", Matchers.equalTo(true));
        validatableResponse.body("bookingid", Matchers.notNullValue());

        bookingId = response.then().extract().path("bookingid");
        String firstName = response.then().extract().path("booking.firstname");
        String lastName = response.then().extract().path("booking.lastname");


        //TestNG Assertion
        System.out.println("TestNG");
        Assert.assertNotNull(bookingId);
        Assert.assertEquals(firstName, "Josh");
        Assert.assertEquals(lastName, "Allen");

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(firstName,"Josh");
        softAssert.assertAll();


        //AssertJ Assertion
        System.out.println("AssertJ");
        assertThat(bookingId).isNotNull().isNotZero().isPositive();
        assertThat(firstName).isEqualTo("Josh").isNotEmpty().isNotBlank().isNotNull();
        assertThat(lastName).isEqualTo("Allen").isNotEmpty().isNotBlank().isNotNull();
    }
}