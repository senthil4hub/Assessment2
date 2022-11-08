package assessmentchaining;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PutIncidentWithFile extends RestAssuredBase {
    @Test(dependsOnMethods = "assessmentchaining.CreateIncidentWithFile.create")
	public void put() {
    	File fileName= new File("./src/test/resources/updateincident.json");
    	Response response = RestAssured.given().contentType("application/json")
    			.header("Authorization","Bearer 2mZ0f1u7Eaoj29KVco_KHCtJOzfdEbfPWyU8vTckP9QA2v0Yer8dhYe8ziHC2OavD5AdloyHytNk1Au49qRjDA")
    			.when().body(fileName).put("/incident/"+sys_id);
    	response.prettyPrint();
 
    	System.out.println(response.getStatusCode());
    	
  

	}

}
