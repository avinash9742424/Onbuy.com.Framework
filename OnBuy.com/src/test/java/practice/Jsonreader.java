package practice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Jsonreader {

	
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		  
		JSONParser jp=new JSONParser();
		Object obj = jp.parse(new FileReader("C:\\Users\\ADMIN\\eclipse-workspace\\OnBuy.com\\src\\test\\resources\\data.json"));
	
		
		JSONObject js=(JSONObject)obj;
		System.out.println(js.get("url"));
	}
	
	
}
