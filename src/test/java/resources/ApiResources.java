package resources;

public enum ApiResources {
	//enum is a special class in java with has collections of constants and methods
	AddPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json");
	private String resource;

	ApiResources(String resource) {
		this.resource = resource;
	}
	
	public String getResource() {
		return resource;
	} 
	
}