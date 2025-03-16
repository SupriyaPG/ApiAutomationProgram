package com.spgtesting.Ex10_PayloadManagement.GSON;

import com.google.gson.Gson;
import com.spgtesting.Ex10_PayloadManagement.Manual.BookingDates;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class APITesting_28_GSON {

    // GSON - is Google Lib - which will convert class to JSON and JSON to class
    //JSON - is a plain text in key and value pair to transfer from client to server
    //for use GSON install it's  dependencies
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;

    @Test
    public  void test_Create_Booking_Positive(){

        Booking booking=new Booking();
        booking.setFirstname("QSBlOCiG");
        booking.setLastname("JQknuiuY");
        booking.setTotalprice(464);
        booking.setDepositpaid(true);

        BookingDates bookingdates=new BookingDates();
        bookingdates.setCheckin("2024-01-01");
        bookingdates.setCheckout("2024-01-02");

        booking.setBookingdates(bookingdates);

        System.out.println(booking);
        // here booking is java object
        //to send it to server we have to convert it into GSON

        Gson gson=new Gson();
        String jsonStringBooking= gson.toJson(booking);
        System.out.println(jsonStringBooking);

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonStringBooking).log().all();

        Response response = requestSpecification.when().post();

        //get validatable response to perform validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        //Case -> 1 Extraction
        String firstname1=response.then().extract().path("booking.firstname");
        System.out.println(firstname1);

        Assert.assertEquals(firstname1,"QSBlOCiG");
        assertThat(firstname1).isNotNull().isNotBlank().isNotEmpty().isEqualTo("QSBlOCiG");


        //Case -> 2 Extraction JSON path extraction
        // jsonPath.getString("")
        JsonPath jsonpath=new JsonPath(response.asString());
        String bookingid=jsonpath.getString("bookingid");
        String firstname=jsonpath.getString("booking.firstname");
        String checkIn=jsonpath.getString("booking.bookingdates.checkin");

        //Case -> 3 Extraction by deserialization
        String jsonresponceString1=response.toString();
       BookingResponse bookingResponse=gson.fromJson(jsonresponceString1, BookingResponse.class);

       System.out.println(bookingResponse.getBookingid());
       System.out.println(bookingResponse.getBooking().getFirstname());
       System.out.println(bookingResponse.getBooking().getFirstname());

       assertThat(bookingResponse.getBookingid()).isNotNull().isPositive();
       assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("QSBlOCiG").isNotEmpty().isNotBlank();
    }
}
