package com.newrdmb.ders25.odev18;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.Test;


public class PetStoreTest {
    private static final int PET_ID = 5; // Example existing pet ID

    @Test
    public void testFindPetById() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        // Send a GET request to retrieve the pet by ID
        Response response =
                RestAssured.given()
                        .pathParam("petId", PET_ID)
                        .when()
                        .get("/pet/{petId}")
                        .then()
                        .assertThat()
                        .statusCode(200)
                        .contentType(ContentType.JSON)
                        .extract()
                        .response();

        // Print out the response content type and headers
        System.out.println("Content-Type: " + response.getContentType());
        System.out.println("Headers: " + response.getHeaders());

        // Extract the pet object from the response
        Pet retrievedPet = response.as(Pet.class);

        // Print the retrieved pet for verification
        System.out.println("Retrieved Pet: " + retrievedPet);

        // Assertions to verify the retrieved pet details
        Assertions.assertThat(retrievedPet.getId()).isEqualTo(PET_ID);
        Assertions.assertThat(retrievedPet.getName()).isNotNull();
        Assertions.assertThat(retrievedPet.getStatus()).isNotNull();
    }



}
