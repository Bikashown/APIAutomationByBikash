package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class utils {
	RequestSpecification req;
	public RequestSpecification requestSpecification() throws IOException
	{
		PrintStream stream=new PrintStream(new FileOutputStream("logging.txt"));
		req=new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).addQueryParam("key", "qaclick123").setContentType(ContentType.JSON)
				.addFilter(RequestLoggingFilter.logRequestTo(stream))
				.addFilter(ResponseLoggingFilter.logResponseTo(stream)).build();
		return req;
	}

	
	public static String getGlobalValue(String key) throws IOException
	{
	  Properties prop=new Properties();
	  FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\global.properties");
	  prop.load(fis);
	  return prop.getProperty(key);
	 
	}
}
