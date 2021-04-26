package persistence;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import models.Course;

public class GSONFileManager {
	
	private String LOCATION_FILE = "data/infoServer.json";

	public void writeFile(Object object) throws Exception {
		try {
			FileWriter fileWriter;
			fileWriter = new FileWriter(LOCATION_FILE);
			fileWriter.write(new Gson().toJson(object));
			fileWriter.close();
		} catch (IOException e) {
			throw new Exception("Error al guardar los datos");
		}
	}
	
	public Course readFile(Course object) {
		Course newModel = null;
		try {
			JsonParser json = new JsonParser();
			Gson gson = new Gson();
			Object string = json.parse(new FileReader(LOCATION_FILE));
			newModel = gson.fromJson(string.toString(), Course.class);
			return newModel;
		} catch (JsonIOException | JsonSyntaxException | FileNotFoundException e) {
			e.printStackTrace();
		}
		return newModel;
	}
}