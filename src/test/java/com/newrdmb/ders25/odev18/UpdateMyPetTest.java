package com.newrdmb.ders25.odev18;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class UpdateMyPetTest {
    private static final int PET_ID = 5; // Example existing pet ID
        @Test
    public void testUpdatePet() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
            Map<String, Object> header = new HashMap<>();
            header.put("Accept", "application/json");

        // Create a new Pet object with updated details
        Pet updatedPet = new Pet();
        updatedPet.setId(PET_ID);
        updatedPet.setName("Kamile");
        updatedPet.setStatus("sold");

        // Send a PUT request to update the pet
        Response response =
                RestAssured.given()
                        .contentType(ContentType.JSON)
                        .headers(header)
                        .body(updatedPet)
                        .when()
                        .put("/pet")
                        .then()
                        .assertThat()
                        .statusCode(200)
                        .contentType(ContentType.JSON)
                        .extract()
                        .response();

        // Print out the response content type and headers
        System.out.println("Content-Type: " + response.getContentType());
        System.out.println("Headers: " + response.getHeaders());

        // Extract the updated pet from the response
        Pet responsePet = response.as(Pet.class);

        // Print the updated pet for verification
        System.out.println("Updated Pet: " + responsePet);

        // Assertions to verify the updated pet details
        Assertions.assertThat(responsePet.getId()).isEqualTo(PET_ID);
        Assertions.assertThat(responsePet.getName()).isEqualTo("Kamile");
        Assertions.assertThat(responsePet.getStatus()).isEqualTo("sold");
    }

}
