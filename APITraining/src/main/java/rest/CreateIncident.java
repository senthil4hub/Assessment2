package rest;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateIncident {
    @Test
	public void create() {
    	
    	RestAssured.baseURI="https://dev120775.service-now.com/api/now/table";
    	RestAssured.authentication=RestAssured.basic("admin","Test@123");
    	Response response = RestAssured.given().contentType("application/json").post("/incident");
    	response.then().assertThat().statusCode(201);
    JsonPath path = response.jsonPath();
    String sys_id = path.get("result.sys_id");
    System.out.println("The Extracted sys_ID is"+sys_id);
    File fileName= new File ("./src/main/resources/ValidateSchema.json");
    response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(fileName));
  

	}

}
