package Controller;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.JsonObject;

public class PresentationJSON {
	public static void main(String[] args) throws IOException, ParseException {
		try {

			Reader reader = new FileReader("top20.json");

			JSONParser parser = new JSONParser();
			Object obj = parser.parse(reader);

			JSONArray jsonArr = (JSONArray) obj;
			JsonObject licenseArr = new JsonObject();
			ArrayList list = new ArrayList();
			if (jsonArr.size() > 0) {
				for (int i = 0; i < jsonArr.size(); i++) {
					JSONObject jsonObj = (JSONObject) jsonArr.get(i);
					list.add(jsonObj.get("licenseOrgan"));
					licenseArr.addProperty("licenseOrgan", (String) jsonObj.get("licenseOrgan"));
					System.out.println(licenseArr);
				}
			}
			
			System.out.println(list);
			
		} catch (Exception e) {
			System.out.println("Error");
		}
	}
}