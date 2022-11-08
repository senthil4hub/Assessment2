package assessmentchaining;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateIncidentWithFile extends RestAssuredBase {
    @Test
	public void create() {
    	
    	File fileName= new File("./src/test/resources/incident.json");
    	Response response = RestAssured.given().contentType("application/json")
    			.header("Authorization","Bearer 2mZ0f1u7Eaoj29KVco_KHCtJOzfdEbfPWyU8vTckP9QA2v0Yer8dhYe8ziHC2OavD5AdloyHytNk1Au49qRjDA")
    			.when().body(fileName).post("/incident");
    	response.prettyPrint();
    JsonPath path = response.jsonPath();
    sys_id = path.get("result.sys_id");
    System.out.println("The Extracted sys_ID is"+sys_id);
    	System.out.println(response.getStatusCode());
    	response.then().assertThat().statusCode(201);
    	
	}

}
