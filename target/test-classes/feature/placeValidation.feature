Feature: Validating Place API

@AddPlace @Regression
Scenario Outline: Validate if place is added successfully using Add Place Api
Given Add place payload with "<name>" "<language>" "<address>"
When user calls "AddPlaceAPI"  with http "POST" method
Then api call is success with status code 200
And "status" message is "OK"
And "scope" is "APP"
And verify placeId created maps to "<name>" using "getPlaceAPI"


Examples:
	|name           |language | address           |
	|Michel atherton| English | 26th Street Austin|
# 	|Steve Smith  	| Greek   | Parker street	  |

@DeletePlace @Regression
Scenario: Validste id delete API is working

Given Delete place payload
When user calls "deletePlaceAPI"  with http "POST" method
Then api call is success with status code 200
And "status" message is "OK"
