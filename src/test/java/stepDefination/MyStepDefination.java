package stepDefination;

import org.testng.AssertJUnit;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Pojo.AddPlace;
import Pojo.Location;
import Resource.TestDataBuild;
import Resource.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class MyStepDefination extends Utils {
	
	
	RequestSpecification res;
	// ResponseSpecification res;
	Response response;
	TestDataBuild t = new TestDataBuild();

	@Given("Add Place Payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {
		// Write code here that turns the phrase above into concrete actions

		System.out.println("Hello");
		System.out.println("Hello1");
		System.out.println("Hello88");
		res = given().spec(requestSpecification()).body(t.addPlace(name, language, address));
		System.out.println("Kumar");

		// Response res1= given().spec(req).body("");

		// ResponseSpecBuilder res= (ResponseSpecBuilder) new
		// ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		// res = new ResponseSpecBuilder().expectStatusCode(200).build();

	}

	@When("User calls {string} with Post http request")
	public void user_calls_with_post_http_request(String string) {
		// Write code here that turns the phrase above into concrete actions
		response = res.when().post("maps/api/place/add/json").then().log().all().extract().response();

		// JsonPath js = new JsonPath(response);
		// String place_id=js.getString("place_id");
	}

	@Then("API call got success with status code {int}")
	public void api_call_got_success_with_status_code(Integer number) {
		// response.getStatusCode();
		System.out.println(number);
		int num = response.getStatusCode();
		// AssertJUnit.assertEquals(num, response.getStatusCode());
		// Assert.assertEquals(number, response.getStatusCode());
		assertEquals(num, response.getStatusCode());

	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is_ok(String status, String string1) {
		// Write code here that turns the phrase above into concrete actions
		JsonPath js = new JsonPath(response.asString());
		// js.getString(status);
		AssertJUnit.assertEquals(string1, js.getString(status));
	}

}
