package com.api.stepdefinations;

import java.util.Map;
import java.util.Map.Entry;

import com.utils.ApiUtils;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateJobApiReqStepDef {

	private RequestSpecification reqSpec;
	private Response response;

	@Given("The base url for the create job api {string}")
	public void the_base_url_for_the_create_job_api(String baseUrl) {
		RestAssured.baseURI = baseUrl;
	}

	@And("The header of the create job request")
	public void the_header_of_the_create_job_request(DataTable dataTable) {
		Map<String, String> headers = dataTable.asMap();
		reqSpec = RestAssured.given();
		for (Entry<String, String> hd : headers.entrySet()) {
			reqSpec.header(hd.getKey(), hd.getValue());
		}
		reqSpec.header("Authorization", LoginApiReqStepDef.token);
	}

	@And("The body of the post request")
	public void the_body_of_the_post_request() {
		reqSpec.body(
				"{\"mst_service_location_id\":0,\"mst_platform_id\":2,\"mst_warrenty_status_id\":1,\"mst_oem_id\":1,\"customer\":{\"first_name\":\"Yogesh\",\"last_name\":\"Patil\",\"mobile_number\":\"2345678765\",\"mobile_number_alt\":\"\",\"email_id\":\"ab@cd.com\",\"email_id_alt\":\"\"},\"customer_address\":{\"flat_number\":\"22\",\"apartment_name\":\"ads\",\"street_name\":\"asd\",\"landmark\":\"gsdj\",\"area\":\"asd\",\"pincode\":\"425424\",\"country\":\"India\",\"state\":\"Maharashtra\"},\"customer_product\":{\"dop\":\"2025-06-19T18:30:00.000Z\",\"serial_number\":\"11111111111111110\",\"imei1\":\"11111111111111110\",\"imei2\":\"11111111111111110\",\"popurl\":\"2025-06-19T18:30:00.000Z\",\"product_id\":1,\"mst_model_id\":1},\"problems\":[{\"id\":2,\"remark\":\"sdc\"}]}");
	}

	@When("Post the request of create job with endpoint {string}")
	public void post_the_reques_of_create_jobt_with_endpoint(String endPoint) {
		response = reqSpec.log().all().post(RestAssured.baseURI + endPoint);
	}

	@Then("The job should create with status code {string}")
	public void the_job_should_create(String status) {

	}

	@And("Job id is created")
	public void job_id_is_created() {

	}

}
