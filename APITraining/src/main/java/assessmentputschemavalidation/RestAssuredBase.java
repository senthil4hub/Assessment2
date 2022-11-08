package assessmentputschemavalidation;

import io.restassured.RestAssured;

public class RestAssuredBase {
	
public static String sys_id;	
	
public void setup() 
{
	RestAssured.baseURI="https://dev120775.service-now.com/api/now/table";

}

}
