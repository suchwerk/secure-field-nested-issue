package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;

@QuarkusTest
class GreetingResourceTest {
    @Test
    void testHelloEndpointWithAndWithoutAdmin() {
        // with admin
        given()
                .auth().preemptive().basic("alice", "alice")
                .when().get("/hello")
                .then()
                .statusCode(200)
                .body("entity.prices[0].price", is(1.0f));
        // with no admin
        given()
                .auth().preemptive().basic("bob", "bob")
                .when().get("/hello")
                .then()
                .statusCode(200)
                .body("entity.prices[0].price", is(nullValue()));
    }

}