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
		
//		js.put("email","eve.holt@reqres.in");
//		js.put("password","pistol");
//		js.put("id", "26");
		js.put("name", "test2");
		js.put("salary", "129");
		js.put("age","25");
		
		req.header("Content-Type","application/json");
		req.body(js.toJSONString());
		
		Response res = req.request(Method.POST, "/create");
		
		String respBody = res.getBody().asString();
		System.out.println("Response is "+ respBody);
		
		int statusCode = res.getStatusCode();
		System.out.println("Response code is " + statusCode);
		Assert.assertEquals(statusCode, 200);
		
		String sCode = res.jsonPath().get("status");
		Assert.assertEquals(sCode, "success");

// Output - Response is {"status":"success","data":{"name":"test2","salary":"129","age":"25","id":5197},"message":"Successfully! Record has been added."}
//		Response code is 200
	}	
}
