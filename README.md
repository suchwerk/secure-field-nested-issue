
### Issue: Failing to apply @SecureField to nested objects.


**Steps to Reproduce:**
1. Run the test [`testHelloEndpointWithAndWithoutAdmin`](src/test/java/org/acme/GreetingResourceTest.java ) in [`GreetingResourceTest`](src/test/java/org/acme/GreetingResourceTest.java ).

**Expected Result:**
The test should pass with the following assertions:
- With admin credentials (`alice`), the response should have a status code of 200 and the [`price`](src/main/java/org/acme/Fruit.java ) field should be `1.0`.
- Without admin credentials (`bob`), the response should have a status code of 200 and the [`price`](src/main/java/org/acme/Fruit.java ) field should be `null`.

**Actual Result:**
The test fails because the [`price`](src/main/java/org/acme/Fruit.java ) field value does not match the expected values.

**Relevant Code:**
```java
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
```

**Environment:**
- Quarkus version: 3.16.4
- Java version: 21
