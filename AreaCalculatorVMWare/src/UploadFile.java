import java.io.BufferedReader;
import java.io.FileReader;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.vmware.areacalc.Area;
import com.vmware.areacalc.AreaHandler;

public class UploadFile {

	private static final String CIRCLE = "circle";
	private static final String SQUARE = "square";
	private static final String RECTANGLE = "rectangle";
	
	public static void main(String[] args) {
		BufferedReader reader;
		try {
			AreaHandler areaHandler = new AreaHandler();
			reader = new BufferedReader(new FileReader("C:\\Users\\akila\\eclipse-workspace\\AreaCalculatorVMWare\\src\\json"));

			StringBuilder stringBuilder = new StringBuilder();
			String line = null;
			String ls = System.getProperty("line.separator");
			while ((line = reader.readLine()) != null) {
				stringBuilder.append(line);
				stringBuilder.append(ls);
			}
			stringBuilder.deleteCharAt(stringBuilder.length() - 1);
			reader.close();
			String jsonString = stringBuilder.toString();
			JsonParser parser = new JsonParser();
			JsonObject areaObj = (JsonObject) parser.parse(jsonString); 
			JsonObject jsonObj = new JsonObject();
			for(String key : areaObj.keySet()) {
				System.out.println(key);
				System.out.println(areaObj.getAsJsonObject(key).get("type").getAsString());
				Area area = areaHandler.getArea(areaObj.getAsJsonObject(key).get("type").getAsString());
				int areaValue = 0;
				if(areaObj.getAsJsonObject(key).get("type").getAsString().equalsIgnoreCase(CIRCLE)) {
					System.out.println(areaObj.getAsJsonObject(key).get("radius").getAsInt());
					int [] a = {areaObj.getAsJsonObject(key).get("radius").getAsInt()};
					areaValue = area.area(a);
				} else if(areaObj.getAsJsonObject(key).get("type").getAsString().equalsIgnoreCase(RECTANGLE)){
					int [] a = {areaObj.getAsJsonObject(key).get("l").getAsInt(),areaObj.getAsJsonObject(key).get("b").getAsInt()};
					areaValue = area.area(a);
				} else if(areaObj.getAsJsonObject(key).get("type").getAsString().equalsIgnoreCase(SQUARE)) {
					int [] a = {areaObj.getAsJsonObject(key).get("side").getAsInt()};
					areaValue = area.area(a);
				}
				jsonObj.addProperty(key, String.valueOf(areaValue));
			}
			System.out.println(jsonObj);
		} catch (Exception e) {
			System.out.println("Exception occured" + e);
			e.printStackTrace();
		}
	}

}
