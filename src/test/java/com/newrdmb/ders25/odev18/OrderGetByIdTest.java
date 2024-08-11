package com.newrdmb.ders25.odev18;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.assertj.core.api.Assertions;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class OrderGetByIdTest {


    @Test
    public void testGetOrderById() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        int orderId = 5; // Example order ID


    Response response =
            RestAssured.given()
                    .pathParam("orderId", orderId)
                    .when()
                    .get("/store/order/{orderId}")
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .contentType(ContentType.JSON)
                    .extract()
                    .response();

    // Print out the response content type and headers
        System.out.println("Content-Type: " + response.getContentType());
        System.out.println("Headers: " + response.getHeaders());

    // Extract the order object from the response

        Order order = response.as(Order.class);

    // Print the order object for verification
        System.out.println("Order: " + order);

    // Assertions to verify the order details
        Assertions.assertThat(order.getId()).isEqualTo(orderId);
        Assertions.assertThat(order.getStatus()).isNotNull();

  }
    @Test
    public void testGetOrderByInvalidId() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        int invalidOrderId = 2; // Example invalid order ID
        String contentType = ContentType.JSON.toString();
        Response response =
                RestAssured.given()
                        .pathParam("orderId", invalidOrderId)
                        .when()
                        .get("/store/order/{orderId}")
                        .then()
                        .assertThat()
                        .statusCode(404)  // Expecting a 404 status for invalid ID
                        .contentType(contentType)
                        .extract()
                        .response();

        // Print out the response content type and headers
        System.out.println("Content-Type: " + response.getContentType());
        System.out.println("Headers: " + response.getHeaders());

        // Print the error message for debugging
        String errorMessage = response.asString();
        System.out.println("Error Message: " + errorMessage);

        // Assertions to verify the response
        Assertions.assertThat(response.getStatusCode()).isEqualTo(404);
    }
}
