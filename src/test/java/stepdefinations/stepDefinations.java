package stepdefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.Location;
import pojo.addPlacePayLoad;
import resources.testDataBuild;
import resources.utils;

public class stepDefinations extends utils{

	RequestSpecification iniReq;
	ResponseSpecification res;
	Response response;
	testDataBuild testdata=new testDataBuild();
	
	@Given("Add place payload with {string} {string} {string}")
	public void add_place_payload(String name, String language,String address) throws IOException {
		
		iniReq= given().spec(requestSpecification()).body(testdata.addPlaceAPIData(name,language,address));
		res=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	}
	
	@When("User calls {string} with Post http request")
	public void user_calls_with_post_http_request(String string) {
		
	    
		
		response=iniReq.when().post("/maps/api/place/add/json").then().spec(res).extract().response();
	   
	}
	
	@Then("the API call is success with status code is {int}")
	public void the_api_call_is_success_with_status_code_is(Integer int1) {
	 assertEquals(response.getStatusCode(),200);
	}
	
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String expectedValue) {
	   
		String res=response.asString();
		JsonPath js=new JsonPath(res);
		assertEquals(js.getString(keyValue),expectedValue);
	}
	
	

}
