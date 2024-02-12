package stepDefinitions;

import io.cucumber.java.Before;
import java.io.IOException;

public class Hooks {
	@Before("@DeletePlace")
	public void BeforeScenario() throws IOException {
		//execute this code only when place id is null
		//writing a code so as to get place id
		StepDefinition m = new StepDefinition();
		if(StepDefinition.placeId==null) {
			
			m.add_place_payload_with("Akash", "Angreji", "Villa 6");
			m.user_calls_with_http_method("AddPlaceAPI", "POST");
			m.verify_place_id_created_maps_to_using("Akash", "getPlaceAPI");
		}
	}

}
