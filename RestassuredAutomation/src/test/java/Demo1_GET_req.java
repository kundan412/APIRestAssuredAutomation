import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo1_GET_req {

	@Test
	void getWeatherDetails()
	{
		//specify Base URI
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/employee";
		
		// representing the request object
		RequestSpecification httpRequest = RestAssured.given();
		
		// representing the response object
		Response resp = httpRequest.request(Method.GET, "/1");
		
		String respBody = resp.getBody().asString();
		System.out.println("Response body is :" + respBody);
		
		//status code
		int respStatusCode = resp.getStatusCode();
		System.out.println("Status code is : " + respStatusCode);
		Assert.assertEquals(respStatusCode, 200);
		
		//status line verification
		String respStatusLine = resp.statusLine();
		System.out.println("Status line is " + respStatusLine);
		Assert.assertEquals(respStatusLine, "HTTP/1.1 200 OK");
		
	}
}
