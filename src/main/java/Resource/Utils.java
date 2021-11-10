package Resource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import com.sun.xml.bind.v2.runtime.property.Property;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils {
	
	public static RequestSpecification req;
	
	public RequestSpecification requestSpecification() throws IOException
	{
		
		if(req==null)
		{
		PrintStream log = new PrintStream(new FileOutputStream("loggin.txt"));
		 RestAssured.baseURI="https://rahulshettyacademy.com";
	        
	        req = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).addQueryParam("key", "qaclick123")
	        .setContentType(ContentType.JSON).
	        addFilter(RequestLoggingFilter.logRequestTo(log)).
	        addFilter(ResponseLoggingFilter.logResponseTo(log)).build();
	        return req;
		}
		return req;
	}
	
	public static  String getGlobalValue(String key) throws IOException
	{
		String path = System.getProperty("user.dir");
		Properties p = new Properties();
		FileInputStream fis = new FileInputStream(path+"/src/main/java/Resource/global.properties");
		p.load(fis);
		return p.getProperty(key);
	}

}
