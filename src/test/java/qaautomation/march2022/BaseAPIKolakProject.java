package qaautomation.march2022;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;

import com.github.javafaker.Faker;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import qaautomation.march2022.utils.DataUtility;

public class BaseAPIKolakProject {
	RequestSpecification kolakCommonJsonSpec = new RequestSpecBuilder().setBaseUri("https://kolakproject.herokuapp.com")
			.setContentType(ContentType.JSON).build().log().all();
	RequestSpecification registerKolakJsonSpec;
	String username;
	String password;
	String email;
	String phoneNumber;

	public Response registerKolak() {

		Faker faker = new Faker();
		username = faker.name().firstName().toLowerCase();
		password = username + "123";
		email = username + "@yopmail.com";
		phoneNumber = faker.phoneNumber().phoneNumber();
//		System.out.println(username);
//		System.out.println(password);
//		System.out.println(email);
//		System.out.println(phoneNumber);

		String registerKolakPayload = "{\"username\":\"" + username + "\", \"password\": \"" + password
				+ "\", \"email\":\"" + email + "\", \"phonenumber\":\"" + phoneNumber + "\"}";

//		String registerKolakPayload = DataUtility.getDataFromExcel("Payloads", "RegisterKolakPayload");
		Response responseRegisterKolak = given().spec(kolakCommonJsonSpec).body(registerKolakPayload).when()
				.post("/register");
		registerKolakJsonSpec = new RequestSpecBuilder()
				.setBaseUri(DataUtility.getDataFromExcel("Config", "EndPointKolak")).setBody(registerKolakPayload)
				.setContentType(ContentType.JSON).build().log().all();

		return responseRegisterKolak;
	}

}
