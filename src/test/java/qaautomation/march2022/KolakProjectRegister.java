package qaautomation.march2022;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import qaautomation.march2022.pages.LoginPage;
import qaautomation.march2022.utils.DataUtility;

public class KolakProjectRegister extends BaseAPIKolakProject {

	@Test
	public void registerKolakSuccess() {

		String registerKolakPayload = generateRegisterPayload();

		Response responseRegisterKolak = given().spec(kolakCommonJsonSpec).body(registerKolakPayload).when()
				.post("/register");
		registerKolakJsonSpec = new RequestSpecBuilder()
				.setBaseUri(DataUtility.getDataFromExcel("Config", "EndPointKolak")).setBody(registerKolakPayload)
				.setContentType(ContentType.JSON).build().log().all();
		assertEquals(responseRegisterKolak.getStatusCode(), 201);
		responseRegisterKolak.then().assertThat()
				.body(matchesJsonSchema(DataUtility.getDataFromExcel("Schemas", "RegisterKolakSchemas")));

	}

	@Test
	public void registerKolakHasBeenTaken() {

		String registerKolakPayload = generateRegisterPayload();

		given().spec(kolakCommonJsonSpec).body(registerKolakPayload).when().post("/register");

		Response responseRegisterKolak = given().spec(kolakCommonJsonSpec).body(registerKolakPayload).when()
				.post("/register");

		registerKolakJsonSpec = new RequestSpecBuilder()
				.setBaseUri(DataUtility.getDataFromExcel("Config", "EndPointKolak")).setBody(registerKolakPayload)
				.setContentType(ContentType.JSON).build().log().all();
		assertEquals(responseRegisterKolak.getStatusCode(), 400);
		responseRegisterKolak.then().assertThat()
				.body(matchesJsonSchema(DataUtility.getDataFromExcel("Schemas", "DashboardNoParamSchema")));

	}


	private String generateRegisterPayload() {
		Faker faker = new Faker();
		username = faker.name().firstName().toLowerCase();
		password = username + "123";
		email = username + "@yopmail.com";
		phoneNumber = faker.phoneNumber().phoneNumber();
		String registerKolakPayload = "{\"username\":\"" + username + "\", \"password\": \"" + password
				+ "\", \"email\":\"" + email + "\", \"phonenumber\":\"" + phoneNumber + "\"}";
		return registerKolakPayload;
	}
}
