Feature: Validating Place API's

Scenario Outline: Verify if Place is being successfully added
Given Add Place Payload with "<name>" "<language>" "<address>"
When User calls "AddPlaceAPI" with Post http request
Then API call got success with status code 200
And "status" in response body is "OK"
And "scope" in response body is "APP"

Examples:
|name  | language | address|
|Deepak| Hindi    | Khurja |
|Deepak1| English    | Noida |