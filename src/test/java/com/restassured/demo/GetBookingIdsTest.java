package com.restassured.demo;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GetBookingIdsTest {

    @Test
    public void getBookingIdsTest() {

        //Get response for booking ids
        Response response = RestAssured.get("https://restful-booker.herokuapp.com/booking");
        response.print();

        //Validate status code 200
        Assert.assertEquals(response.getStatusCode(), 200, "status code not 200");

        //Validate ids in response
        List<Integer> bookingIds = response.jsonPath().getList("bookingid");
        Assert.assertFalse(bookingIds.isEmpty(), "no booking ids in response");

    }
}
