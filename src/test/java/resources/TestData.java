package resources;

import addPlacePojo.AddPlace;
import addPlacePojo.Location;
import java.util.ArrayList;

public class TestData {
	public AddPlace addPlace(String name, String language, String address)
	{
		AddPlace p = new AddPlace();
		p.setAccuracy(50);
		p.setName(name);
		p.setAddress(address);
		p.setLanguage(language);
		p.setPhone_number("+91 9393300303");
		p.setWebsite("www.RahulShettyAcademy.com");
		
		ArrayList<String> setTypes = new ArrayList<String>();
		setTypes.add("Shoe Park");
		setTypes.add("Shoe");
		p.setTypes(setTypes);
		
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		p.setLocation(l);
		return p;
	}
	
	public String deletePlacePayload(String placeid) {
		return "{\r\n"
				+ "    \"place_id\": \""+placeid+"\"\r\n"
				+ "}";
	}
}
