package assessmentchaining;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteIncident extends RestAssuredBase {
    @Test(dependsOnMethods = "assessmentchaining.PutIncidentWithFile.put")
	public void delete() {
    	
    	Response response = RestAssured.given().header("Authorization","Bearer 2mZ0f1u7Eaoj29KVco_KHCtJOzfdEbfPWyU8vTckP9QA2v0Yer8dhYe8ziHC2OavD5AdloyHytNk1Au49qRjDA")
    			.delete("/incident/"+sys_id);
   
    	System.out.println(response.getStatusCode());
    	
  

	}

}
