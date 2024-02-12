package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.io.IOException;
import resources.ApiResources;
import resources.TestData;
import resources.Utils;

public class StepDefinition extends Utils {
	RequestSpecification req2;
	ResponseSpecification responsee;
	Response response;
	TestData data = new TestData();
	static String placeId;
	
	@Given("Add place payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException  {
	    // Write code here that turns the phrase above into concrete actions
		req2 =given().spec(requestSpecifications()).body(data.addPlace(name, language, address));
		
	}

	@When("user calls {string}  with http {string} method")
	public void user_calls_with_http_method(String resource, String method) {
	    // Write code here that turns the phrase above into concrete actions
		ApiResources apiresource = ApiResources.valueOf(resource);
		responsee = new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200).build();
		if(method.equalsIgnoreCase("POST")) {
		response =  req2.when().post(apiresource.getResource()).then().spec(responsee).extract().response();
		}
		else if(method.equalsIgnoreCase("GET")) {
			response =  req2.when().get(apiresource.getResource()).then().spec(responsee).extract().response();
		}
	    
	}

	@Then("^api call is success with status code (\\d+)$")
	public void api_call_is_success_with_status_code(int arg1) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(response.getStatusCode(),200);
	   
	}

	@Then("^\"([^\"]*)\" message is \"([^\"]*)\"$")
	public void message_is(String keyValue, String expectedValue) {
	    // Write code here that turns the phrase above into concrete actions
		
		assertEquals(getJsonPath(response,keyValue),expectedValue);
	 
	}

	@Then("^\"([^\"]*)\" is \"([^\"]*)\"$")
	public void is(String keyValue, String expectedValue) {
	    // Write code here that turns the phrase above into concrete actions
	
		assertEquals(getJsonPath(response,keyValue),expectedValue);
	    
	}
	
	@Then("verify placeId created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expaectedName, String resource) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		placeId = getJsonPath(response,"place_id");
		req2 =given().spec(requestSpecifications()).queryParam("place_id", placeId);
		user_calls_with_http_method(resource,"GET");
		String actualName = getJsonPath(response, "name");
		assertEquals(actualName, expaectedName);
	}
	
	@Given("Delete place payload")
	public void delete_place_payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		req2 =given().spec(requestSpecifications()).body(data.deletePlacePayload(placeId));
	}

	
	

}
