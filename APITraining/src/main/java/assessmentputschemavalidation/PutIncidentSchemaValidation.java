package assessmentputschemavalidation;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class PutIncidentSchemaValidation extends RestAssuredBase {
	@Test(dependsOnMethods = "assessmentputschemavalidation.CreateIncident.create")
	public void put() {
		Response response = RestAssured.given().contentType("application/json")
				.header("Authorization",
						"Bearer 2mZ0f1u7Eaoj29KVco_KHCtJOzfdEbfPWyU8vTckP9QA2v0Yer8dhYe8ziHC2OavD5AdloyHytNk1Au49qRjDA")
				.when()
				.body(("{\r\n" + "    \"short_description\": \"Updated via RA Senthilraja\",\r\n"
						+ "    \"description\": \"Description updated via RA Senthilraja\"\r\n" + "}"))
				.put("/incident/" + sys_id);
		response.prettyPrint();

		File fileName = new File("./src/main/resources/ValidateSchema.json");
		response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(fileName));
		System.out.println(response.getStatusCode());

	}

}
