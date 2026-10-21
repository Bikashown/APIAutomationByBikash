Feature: Validating Place APIs

Scenario Outline: Verify if plcae is being successfully added using AddplaceAPI

Given Add place payload with "<name>" "<language>" "<address>"
When User calls "addplace api" with Post http request
Then the API call is success with status code is 200
And "status" in response body is "OK"

Examples:
|name     |language|address|
|Hyderabad|English |Amerpet|