package com.api.stepDefinations;

import java.util.Map;
import java.util.Map.Entry;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import com.utils.ApiUtils;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginApiReqStepDef {
	private RequestSpecification repSpec;
	private Response response;
	public static String token;

	@Given("The base url of app {string}")
	public void the_base_url_of_app(String baseUrl) {
		RestAssured.baseURI = baseUrl;
	}

	@Given("The header of the request")
	public void the_header_of_the_request(DataTable dataTable) {
		Map<String, String> header = dataTable.asMap();
		for (Entry<String, String> hd : header.entrySet()) {
			repSpec = RestAssured.given().header(hd.getKey(), hd.getValue());
		}
	}

	@And("Body of the request with {string} and {string}")
	public void body_of_the_request_with_and(String username, String password) {
		repSpec.body("{\"username\":\"" + username + "\",\"" + password + "\":\"password\"}");
	}

	@And("Post the request with endpoint {string}")
	public void post_the_request_with_endpoint(String endPoint) {
		response = repSpec.log().all().post(RestAssured.baseURI + endPoint);
	}

	@And("The response status should be {string}")
	public void the_response_status_should_be(String statusCode) {
		response.then().log().all();
	}

	@Then("Token should not be null")
	public void token_should_not_be_null() {
		token = response.then().log().all().assertThat().body("data.token", Matchers.notNullValue())
				.contentType(ContentType.JSON).extract().jsonPath().getString("data.token");

	}

}
