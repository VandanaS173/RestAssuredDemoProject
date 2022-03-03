package com.restassured.demo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GetBookingById {

    @Test
    public void getBookingById(){

      //Get response for booking id

        Response response= RestAssured.get("https://restful-booker.herokuapp.com/booking/1");
        response.print();

       //Validate Response status code
        Assert.assertEquals(response.getStatusCode(),200,"Status code is not 200");


        //Validate firstname from response

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(response.jsonPath().getString("firstname"),"Susan","firstname is not correct");
        softAssert.assertEquals(response.jsonPath().getString("lastname"),"Brown","lastname is not correct");
        softAssert.assertEquals(response.jsonPath().getInt("totalprice"),812,"totalprice is not correct");
        softAssert.assertTrue(response.jsonPath().getBoolean("depositpaid"),"depositpaid is not correct");
        softAssert.assertEquals(response.jsonPath().getString("bookingdates.checkin"),"2016-09-10","checkin is not correct");
        softAssert.assertEquals(response.jsonPath().getString("bookingdates.checkout"),"2019-06-06","checkout is not correct");
        softAssert.assertEquals(response.jsonPath().getString("additionalneeds"),"Breakfast","additionalneeds is not correct");
        softAssert.assertAll();

    }
}
