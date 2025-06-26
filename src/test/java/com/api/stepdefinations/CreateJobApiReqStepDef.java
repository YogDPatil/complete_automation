package com.api.stepdefinations;

import java.util.Map;
import java.util.Map.Entry;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import com.utils.ApiUtils;
import com.utils.TestUtils;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateJobApiReqStepDef {

	private RequestSpecification reqSpec;
	private Response response;
	static int jobID;

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
		Map<String, String> details = TestUtils.getFakeData();
		reqSpec.body(
				"{\"mst_service_location_id\":0,\"mst_platform_id\":2,\"mst_warrenty_status_id\":1,\"mst_oem_id\":1,\"customer\":{\"first_name\":\""
						+ details.get("fName") + "\",\"last_name\":\"" + details.get("lName")
						+ "\",\"mobile_number\":\"" + details.get("number")
						+ "\",\"mobile_number_alt\":\"\",\"email_id\":\"" + details.get("email")
						+ "\",\"email_id_alt\":\"\"},\"customer_address\":{\"flat_number\":\""
						+ details.get("flatNumber") + "\",\"apartment_name\":\"" + details.get("apptName")
						+ "\",\"street_name\":\"" + details.get("streetName") + "\",\"landmark\":\""
						+ details.get("landmark") + "\",\"area\":\"" + details.get("area") + "\",\"pincode\":\""
						+ details.get("pincode") + "\",\"country\":\"India\",\"state\":\"" + details.get("state")
						+ "\"},\"customer_product\":{\"dop\":\"2025-06-19T18:30:00.000Z\",\"serial_number\":\""
						+ details.get("imei") + "\",\"imei1\":\"" + details.get("imei") + "\",\"imei2\":\""
						+ details.get("imei")
						+ "\",\"popurl\":\"2025-06-19T18:30:00.000Z\",\"product_id\":1,\"mst_model_id\":1},\"problems\":[{\"id\":2,\"remark\":\"sdc\"}]}");
	}

	@When("Post the request of create job with endpoint {string}")
	public void post_the_reques_of_create_jobt_with_endpoint(String endPoint) {
		response = reqSpec.log().all().post(RestAssured.baseURI + endPoint);
	}

	@Then("The job should create with status code {string}")
	public void the_job_should_create(String status) {
		response.then().log().all().assertThat().statusCode(200);
	}

	@And("Job id is created")
	public void job_id_is_created() {
		jobID = response.then().assertThat().body("data.id", Matchers.notNullValue()).contentType(ContentType.JSON)
				.extract().jsonPath().getInt("data.id");
	}

}
