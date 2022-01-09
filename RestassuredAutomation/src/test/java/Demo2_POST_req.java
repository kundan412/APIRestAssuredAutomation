import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Demo2_POST_req {

	@SuppressWarnings("unchecked")
	@Test
	void PostDetails()
	{
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		
		RequestSpecification req = RestAssured.given();
		
		JSONObject js = new JSONObject();
		
		js.put("email","eve.holt@reqres.in");
		js.put("password","pistol");
//		js.put("age","23");
//		js.put("id", "25");
		
//		req.header("Content-Type","application/json");
		req.body(js.toJSONString());
		
		Response res = req.request(Method.POST, "/create");
		
		String respBody = res.getBody().asString();
		System.out.println("Response is "+ respBody);
		
		int statusCode = res.getStatusCode();
		System.out.println("Response code is " + statusCode);
		Assert.assertEquals(statusCode, 201);
		
		String sCode = res.jsonPath().get("Success Code");
		Assert.assertEquals(sCode, "success");
		
	}	
}
