package Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.json.simple.JSONArray;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class CSVtoJSON {
	public static void main(String[] args) throws IOException {
		ArrayList CSVList = new ArrayList();
		FileReader in = new FileReader("top20.csv");
		BufferedReader in2 = new BufferedReader(in);

		JSONArray JSONList = new JSONArray();
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("top20.json")));

		String line;

		while ((line = in2.readLine()) != null) {
			System.out.println(line); // CSV형식 출력
			CSVList.add(line);
		}
		String str;
		String[] arr;
		for (int i = 1; i < CSVList.size(); i++) {

			JsonObject resultObj = new JsonObject();
			str = (String) CSVList.get(i);
			if (str == null || str.isEmpty()) {
				continue;
			}
			arr = str.split(",");

			resultObj.addProperty("id", arr[0]);
			resultObj.addProperty("title", arr[1]);
			resultObj.addProperty("licenseOrgan", arr[2]);
			resultObj.addProperty("esRegdt", arr[3]);
			JSONList.add(resultObj);

		}
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonOutput = gson.toJson(JSONList);
		out.println(jsonOutput);
		out.close();
	}
}