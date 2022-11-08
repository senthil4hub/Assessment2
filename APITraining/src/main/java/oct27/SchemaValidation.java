package oct27;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class SchemaValidation {
	@Test
	public void create() {

		RestAssured.baseURI = "https://dev120775.service-now.com/api/now/table";
		Response response = RestAssured.given().contentType("application/json")
				.header("Authorization",
						"Bearer mZP7NzrrrSaH54IlAtlUwzx9C4vvAnjGlq5sF33pRJwcKuMmsO46T0bzgKLLJl3WINzPRJSpcZ8ZMrkRPEfZxw")
				.when()
				.body("{\r\n" + "    \"short_description\": \"created via Postman Senthilraja\",\r\n"
						+ "    \"description\": \"Description added via Postman Senthilraja\"\r\n" + "}")
				.post("/incident");

		response.prettyPrint();
		JsonPath path = response.jsonPath();
		String sys_id = path.get("result.sys_id");
		System.out.println("The Extracted sys_ID is" + sys_id);
		System.out.println(response.getStatusCode());

	}

}
