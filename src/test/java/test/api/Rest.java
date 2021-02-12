package test.api;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Rest {
    @Test(description = "Get all posts")
    public void geAllPosts() {
	RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts";
	String Resp = given().when().get("").then().assertThat().statusCode(200).extract().response().asString();
	System.out.println("Response is\t" + Resp);
    }

    @Test(description = "Create a post")
    public void postRequest() {
	RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
	String requestBody = 
		
		"{\"mode\": \"raw\",\"raw\": \"{\\r\\n\\t\\\"title\\\": \\\"foo\\\",\\r\\n    \\\"body\\\": \\\"bar\\\",\\r\\n    \\\"userId\\\": 1\\r\\n}\"}";

	Response response = given().header("Content-type", "application/json").and().body(requestBody).when()
		.post("/posts").then().extract().response();
	Assert.assertEquals(201, response.statusCode());

    }
}
