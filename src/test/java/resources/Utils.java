package resources;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Utils {
	
	public static RequestSpecification req;
	public RequestSpecification requestSpecifications() throws IOException {
		
		if(req == null) { //this if condition is added so that logger file dont get override in next test run in second scenario
		PrintStream log = new PrintStream(new FileOutputStream("logger.txt"));
		
		req =new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).addQueryParam("key", "qaclick123").build();
		return req;
		}
		return req;
		
	}
	
//	public static String getGlobal(String key) throws IOException{
//		Properties prop = new Properties();
//		FileInputStream fil = new FileInputStream("C:\\Users\\PRACHITI\\eclipse-workspace\\APIAutomationWithCucumber\\src\\test\\java\\resources\\globalValues.properties");
//		prop.load(fil);
//		return prop.getProperty(key);
//	}
	public String getJsonPath(Response response, String key) {
		String respo = response.asString();
		JsonPath js = new JsonPath(respo);
		return js.get(key).toString();
	}
	

}
