package rest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetIncidentsWithQueryParam {
    @Test
	public void getIncident() {
    	
    	RestAssured.baseURI="https://dev120775.service-now.com/api/now/table";
    	Response response = RestAssured.given().
    queryParam("sysparm_fields","sys_id").
    queryParam("sysparm_fields","4").
    accept("application/xml").
    header("Authorization","Basic YWRtaW46VGVzdEAxMjM=").when().get("/incident");
    	response.prettyPrint();
    	System.out.println(response.getStatusCode());
    	
  

	}

}
