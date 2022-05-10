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

	
}
